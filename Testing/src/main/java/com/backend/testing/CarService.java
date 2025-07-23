package com.backend.testing;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(long id) {
        return carRepository.findById(id).get();
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCarById(long id) {
        carRepository.deleteById(id);
    }


}
