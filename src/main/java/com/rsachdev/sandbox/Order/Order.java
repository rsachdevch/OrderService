package com.rsachdev.sandbox.Order;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customers")
public class Order {
    @Id
    private String id;
    private String pizzaId;
    private String customerId;

    public Order(){
    }

    public Order(String pizzaId, String customerId){
        super();
        this.pizzaId = pizzaId;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public String getPizzaId() {
        return pizzaId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
