package com.jay.Food.Ordering.App.repository;

import com.jay.Food.Ordering.App.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String username);

}
