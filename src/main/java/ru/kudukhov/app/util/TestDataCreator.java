package ru.kudukhov.app.util;

import ru.kudukhov.app.model.Car;
import ru.kudukhov.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;


import java.util.Arrays;
import java.util.List;


@Component
public class TestDataCreator {
    private final CarService carService;

    @Autowired
    public TestDataCreator(CarService carService) {
        this.carService = carService;
    }

    @PostConstruct
    public void insertTestData() {
        createTestData().forEach(this.carService::add);
    }

    public List<Car> createTestData() {
        Car c1 = new Car();
        c1.setBrand("Toyota");
        c1.setModel("Corolla");
        c1.setRegistrationNumber("A123BC");
        c1.setVehicleType("Sedan");
        c1.setYearOfManufacture(2020);
        c1.setHasTrailer(false);

        Car c2 = new Car();
        c2.setBrand("Ford");
        c2.setModel("Focus");
        c2.setRegistrationNumber("B321CX");
        c2.setVehicleType("Hatchback");
        c2.setYearOfManufacture(2018);
        c2.setHasTrailer(false);

        return Arrays.asList(c1, c2);
    }
}
