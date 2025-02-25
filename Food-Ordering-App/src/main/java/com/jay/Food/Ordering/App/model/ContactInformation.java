package com.jay.Food.Ordering.App.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// no entity because we don't need it
@AllArgsConstructor
@NoArgsConstructor
public class ContactInformation {



    private  String email;

    private String mobile;

    private String twitter;

    private String instagram;

}
