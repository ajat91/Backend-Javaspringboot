package com.example.backend_angular.repository;

import com.example.backend_angular.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository <Food,Long> {
}
