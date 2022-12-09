package com.example.backend_angular.service;

import com.example.backend_angular.dto.FoodDTO;
import com.example.backend_angular.model.Food;
import java.util.List;

public interface FoodService {

    Food create (Food food);
    Food update (Long id,Food food);

    Boolean delete(Long id);
    Food findById(Long id);
    List<Food> findAll();

    FoodDTO mapToDto(Food food);
    Food mapToEntity (FoodDTO FoodDTO);


}
