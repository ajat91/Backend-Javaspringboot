package com.example.backend_angular.controller;


import com.example.backend_angular.dto.FoodDTO;
import com.example.backend_angular.model.Food;
import com.example.backend_angular.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/food")
public class FoodController {
    @Autowired
    FoodService foodService;

    @PostMapping("/create")
    public FoodDTO create(@RequestBody FoodDTO request) {
        final Food food = foodService.mapToEntity(request);
        final Food result=foodService.create(food);
        return foodService.mapToDto(result);
    }

    @GetMapping("/all")
    public List <FoodDTO> findAll(){
        return foodService.findAll().stream().map(food->foodService.mapToDto(food))
                .collect(Collectors.toList());
    }

    @GetMapping("/detail/{id}")
    public FoodDTO findById(@PathVariable Long id){
        final Food result=foodService.findById(id);
        return foodService.mapToDto(result);

    }

    @PutMapping("/update/{id}")
    public FoodDTO update(@PathVariable Long id,@RequestBody FoodDTO request){
        final Food food=foodService.mapToEntity(request);
        final Food result=foodService.update(id,food);
        return foodService.mapToDto(result);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return foodService.delete(id);
    }
}
