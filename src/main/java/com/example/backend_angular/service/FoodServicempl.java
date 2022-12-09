package com.example.backend_angular.service;

import com.example.backend_angular.dto.FoodDTO;
import com.example.backend_angular.model.Food;
import com.example.backend_angular.repository.FoodRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional

public class FoodServicempl implements FoodService  {
    @Autowired
    FoodRepository foodRepository;

    @Override
    public Food create(Food food) {
        final Food result = foodRepository.save(food);
        return result;
    }

    @Override
    public Food update(Long id, Food food) {
        final Food result =findById(id);
            if(result != null){
                result.setName(food.getName());
                result.setLokasi(food.getLokasi());
                result.setDeskripsi(food.getDeskripsi());
                return foodRepository.save(result);
            }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Food result=findById(id);
        if(result !=null){
            foodRepository.deleteById(id);
            return true;
        }
        return null;
    }

    @Override
    public Food findById(Long id) {
        Optional<Food> result=foodRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    ObjectMapper mapper=new ObjectMapper();

    @Override
    public FoodDTO mapToDto(Food food){
        return mapper.convertValue(food,FoodDTO.class);
    }

    @Override
    public Food mapToEntity(FoodDTO foodDTO){
        return mapper.convertValue(foodDTO,Food.class);
    }
}
