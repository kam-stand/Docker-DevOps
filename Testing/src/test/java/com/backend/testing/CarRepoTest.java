package com.backend.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CarRepoTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void createCarTest() {
        Car car = new Car("Ford", "Expedition", 2004);
        Car savedCar = carRepository.save(car);

        Assertions.assertNotNull(savedCar.getId());
        Assertions.assertEquals("Ford", savedCar.getMake());
        Assertions.assertEquals("Expedition", savedCar.getModel());
        Assertions.assertEquals(2004, savedCar.getYear());
    }
}
