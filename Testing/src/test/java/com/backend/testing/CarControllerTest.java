package com.backend.testing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllCars() throws Exception {
        Car car1 = new Car("Ford", "F-150", 2025);
        Car car2 = new Car("Ram", "Big Horn", 2025);
        Car car3 = new Car("Toyota", "Tundra", 2025);

        List<Car> cars = Arrays.asList(car1, car2, car3);

        // Mock the service response
        given(carService.getAllCars()).willReturn(cars);

        mockMvc.perform(get("/api/v1/cars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].make", is("Ford")))
                .andExpect(jsonPath("$[1].make", is("Ram")))
                .andExpect(jsonPath("$[2].make", is("Toyota")));
    }

    @Test
    public void getCarById() throws Exception {
        Car car1 = new Car("Ford", "F-150", 2025);
        car1.setId(1L); // Set a mock ID for the test

        // Mock service to return car1 when id = 1
        given(carService.getCarById(1L)).willReturn(car1);

        mockMvc.perform(get("/api/v1/cars/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.make", is("Ford")))
                .andExpect(jsonPath("$.model", is("F-150")))
                .andExpect(jsonPath("$.year", is(2025)));
    }

    @Test
    public void createCar() throws Exception {
        Car car1 = new Car("Honda", "Accord", 2006);
        car1.setId(1L); // Optional, for consistency in JSON response

        given(carService.saveCar(car1)).willReturn(car1);

        mockMvc.perform(post("/api/v1/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(car1)))
                .andExpect(status().isOk()) // or isCreated() if you change the controller
                .andExpect(jsonPath("$.make", is("Honda")))
                .andExpect(jsonPath("$.model", is("Accord")))
                .andExpect(jsonPath("$.year", is(2006)));
    }


}
