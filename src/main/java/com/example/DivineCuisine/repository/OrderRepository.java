package com.example.DivineCuisine.repository;
import com.example.DivineCuisine.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}