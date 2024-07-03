package com.jay.Food.Ordering.App.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne// one 1 owner for one restaurant
    private User owner;

    private String name;

    private String description;

    private String CuisineType;

    @OneToOne// th
    private Address address;

    @Embedded
    private ContactInformation contactInformation;

    private String openingHours;

    // the same name in order field which map by order
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    @Column(length = 1000)
    private List<String> images ;

    private LocalDateTime registrationDate;

    private boolean open;

    @JsonIgnore// to ignore the food list
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)// one restaurant has multiple foods
    private List<Food> foods = new ArrayList<>();




}
