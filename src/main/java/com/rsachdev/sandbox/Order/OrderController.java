package com.rsachdev.sandbox.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;

    @Autowired
    PizzaOrderProxy pizzaOrderProxy;

    public OrderController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping("/all")
    public List<Order> getAll(){
        List<Order> orders = this.orderRepository.findAll();

        return orders;
    }

    @GetMapping("/id/{id}")
    public Optional<Order> getById(@PathVariable("id") String id){
        Optional<Order> order = this.orderRepository.findById(id);
        return order;
    }

    @GetMapping("/cid/{cid}")
    public Order getByCustomerId(@PathVariable("cid") String cid){
        Order order = this.orderRepository.findByCustomerId(cid);
        return order;
    }

    @PostMapping
    public void insert(@RequestBody Order order){
        this.orderRepository.insert(order);
    }

    @PutMapping
    public void update(@RequestBody Order order){
        this.orderRepository.save(order);
    }

    @GetMapping("pizzas/pizzaId/{name}/cid/{cid}")
    public String getPizzaFromProxy(@PathVariable("name") String name, @PathVariable("cid") String customerId){
        String pizzaId = pizzaOrderProxy.orderPizza(name);
        Order newOrder = new Order(pizzaId, customerId);
        this.orderRepository.insert(newOrder);
        return pizzaId;
    }


}
