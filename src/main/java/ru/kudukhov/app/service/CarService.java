package ru.kudukhov.app.service;

import ru.kudukhov.app.model.Car;

import java.util.List;


public interface CarService {
    void add(Car car);

    void update(Car car);

    void remove(long id);

    Car getById(long id);

    List<Car> getAll();
}