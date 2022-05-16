package htwberlinwebtech.Kalotracker;

import htwberlinwebtech.Kalotracker.web.api.Food;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FoodRestController {

    private List<Food> food;

    public FoodRestController() {
        food = new ArrayList<>();
        food.add(new Food(1, "Banane", 30, 20, 39, 200));
        food.add(new Food(2, "Apfel", 100, 8, 12, 400));
    }

    @GetMapping(path = "/api/v1/food")
    public ResponseEntity<List<Food>> fetchFood()  {
        return ResponseEntity.ok(food);
    }
}
