package htwberlinwebtech.Kalotracker;

import htwberlinwebtech.Kalotracker.Persistence.FoodRepository;
import htwberlinwebtech.Kalotracker.service.FoodService;
import htwberlinwebtech.Kalotracker.web.api.Food;
import htwberlinwebtech.Kalotracker.web.api.FoodCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FoodRestController {

    private final FoodService foodService;


    public FoodRestController(FoodService foodService) {
        this.foodService =  foodService;
    }

    @GetMapping(path = "/api/v1/food")
    public ResponseEntity<List<Food>> fetchFood()  {
        return ResponseEntity.ok(foodService.findAll());
    }

    @PostMapping(path = "/api/v1/food")
    public ResponseEntity<Void> createFood(@RequestBody FoodCreateRequest request) throws URISyntaxException {
        var food = foodService.create(request);
        URI uri = new URI("/api/v1/food/" + food.getId());
        return ResponseEntity.created(uri).build();
    }
}
