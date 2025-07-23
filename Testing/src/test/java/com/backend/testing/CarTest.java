package com.backend.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    void testCarProperties() {
        Car car = new Car("Toyota", "Camry", 2020);

        assertEquals("Toyota", car.getMake());
        assertEquals("Camry", car.getModel());
        assertEquals(2020, car.getYear());
    }
}
