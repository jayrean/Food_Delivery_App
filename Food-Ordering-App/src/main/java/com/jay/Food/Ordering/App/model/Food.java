package com.jay.Food.Ordering.App.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
// this is the food entity class
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Long price;

    @ManyToOne// Many food have same category
    private Category foodCategory;

    @Column(length = 1000)
    @ElementCollection// it will create a seperate table
    private List<String> images;

    private boolean available;

    @ManyToOne//
    private Restaurant restaurant;

    private boolean isvegetarian;
    private boolean isSeasonal;

    @ManyToMany// one food can have many ingredients and many foodds have 1 ingredients
    private List<IngredientsItems> ingredients = new ArrayList<>();


    private Date creationDate;


}
