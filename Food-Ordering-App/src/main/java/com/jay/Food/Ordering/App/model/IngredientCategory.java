package com.jay.Food.Ordering.App.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class IngredientCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @JsonIgnore
    @ManyToOne// one restaurant has many ingredientsCategory
    private Restaurant restaurant;

    @OneToMany(mappedBy = "category", cascade =CascadeType.ALL )
    // one category has many ingredient
    private List<IngredientsItems> ingredients = new ArrayList<>();



}
