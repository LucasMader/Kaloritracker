package htwberlinwebtech.Kalotracker.service;

import htwberlinwebtech.Kalotracker.Persistence.FoodEntity;
import htwberlinwebtech.Kalotracker.Persistence.FoodRepository;
import htwberlinwebtech.Kalotracker.web.api.Food;
import htwberlinwebtech.Kalotracker.web.api.FoodCreateRequest;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;


    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> findAll(){
       List<FoodEntity> food = foodRepository.findAll();
        return food.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Food create(FoodCreateRequest request) {
        var foodEntity = new FoodEntity(request.getName(), request.getKohlenhydrate(), request.getFett(), request.getEiweiß(), request.getKalorien());
        foodEntity = foodRepository.save(foodEntity);
        return transformEntity(foodEntity);
    }

    public Food findById(Long id) {
        var foodEntity = foodRepository.findById(id);
        return foodEntity.map(this::transformEntity).orElse(null);
    }

    private Food transformEntity(FoodEntity foodEntity) {
        return new Food(
                foodEntity.getId(),
                foodEntity.getName(),
                foodEntity.getKohlenhydrate(),
                foodEntity.getFett(),
                foodEntity.getEiweiß(),
                foodEntity.getKalorien()
        );
    }
}
