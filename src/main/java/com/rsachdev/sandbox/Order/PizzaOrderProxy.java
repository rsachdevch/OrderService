package com.rsachdev.sandbox.Order;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="PizzaService")
@RibbonClient(name="PizzaService")
public interface PizzaOrderProxy {
    @GetMapping("pizzas/pizzaId/{name}")
    public String orderPizza(@PathVariable("name") String name);
}
