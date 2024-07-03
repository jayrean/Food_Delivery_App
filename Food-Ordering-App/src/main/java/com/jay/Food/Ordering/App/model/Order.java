package com.jay.Food.Ordering.App.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // many order have same user
    @ManyToOne
    private User customer;

    // the user can only order food from one restaurant
    // not from multiple in a single order
    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    private Long totalAmount;

    private String orderStatus;

    private Date createDate;

    // the one address can have multiple orders
    @ManyToOne
    private Address deliveryAddress;


    // in one order user has multiple items
    @OneToMany
    private List<OrderItem> items;


    private int totalItem;

    private int totalPrice;

    //private Payment payment;


}
