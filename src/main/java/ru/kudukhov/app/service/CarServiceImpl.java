package ru.kudukhov.app.service;

import ru.kudukhov.app.dao.CarEntityRepository;
import ru.kudukhov.app.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CarServiceImpl implements CarService {
    private final CarEntityRepository carRepository;

    @Autowired
    public CarServiceImpl(CarEntityRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    @Transactional
    public void add(Car car) {
        carRepository.save(car);
    }

    @Override
    @Transactional
    public void update(Car car) {
        carRepository.save(car);
    }

    @Override
    @Transactional
    public void remove(long id) {
        carRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Car getById(long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> getAll() {
        return carRepository.findAll();
    }
}