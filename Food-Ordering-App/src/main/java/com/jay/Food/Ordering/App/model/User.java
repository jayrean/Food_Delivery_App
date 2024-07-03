package com.jay.Food.Ordering.App.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jay.Food.Ordering.App.dto.RestaurantDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String email;
    private String password;

    private USER_ROLE role;

    @JsonIgnore
    // to ignore whole list
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    private List<RestaurantDto>favorites = new ArrayList();

    // to save the address given the user
    // one user can have multiple address
    // if user is deleted we need to delete the address also
    // so CascadeType aal is used.
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> address = new ArrayList<>();

}
