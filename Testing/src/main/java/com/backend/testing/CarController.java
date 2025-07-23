package com.backend.testing;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> getCarById(@PathVariable  Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }
    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        carService.saveCar(car);
        return ResponseEntity.ok(car);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        carService.deleteCarById(id);
        return ResponseEntity.ok().build();
    }


}
