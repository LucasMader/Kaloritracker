package htwberlinwebtech.Kalotracker.service;

import htwberlinwebtech.Kalotracker.Persistence.FoodEntity;
import htwberlinwebtech.Kalotracker.Persistence.FoodRepository;
import htwberlinwebtech.Kalotracker.web.api.Food;
import htwberlinwebtech.Kalotracker.web.api.FoodManipulationRequest;
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

    public Food create(FoodManipulationRequest request) {
        var foodEntity = new FoodEntity(request.getName(), request.getKohlenhydrate(), request.getFett(), request.getEiweiß(), request.getKalorien());
        foodEntity = foodRepository.save(foodEntity);
        return transformEntity(foodEntity);
    }

    public Food findById(Long id){
        var foodEntity = foodRepository.findById(id);
        return foodEntity.map(this::transformEntity).orElse(null);
    }

    public Food update(Long id, FoodManipulationRequest request) {
        var foodEntityOptional = foodRepository.findById(id);
        if (foodEntityOptional.isEmpty()) {
            return null;
        }
        var foodEntity = foodEntityOptional.get();
        foodEntity.setName(request.getName());
        foodEntity.setKohlenhydrate(request.getKohlenhydrate());
        foodEntity.setFett(request.getFett());
        foodEntity.setEiweiß(request.getEiweiß());
        foodEntity.setKalorien(request.getKalorien());
        foodEntity = foodRepository.save(foodEntity);

        return transformEntity(foodEntity);
    }

    public boolean deleteById(Long id) {
        if (!foodRepository.existsById(id)) {
            return false;
        }

        foodRepository.deleteById(id);
        return true;
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
