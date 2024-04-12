package ru.kudukhov.app.service;

import ru.kudukhov.app.dao.CarDao;
import ru.kudukhov.app.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CarServiceImpl implements CarService {
    private CarDao carDao;

    @Autowired
    public void setBookDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    @Transactional
    public void add(Car car) {
        this.carDao.add(car);
    }

    @Override
    @Transactional
    public void update(Car car) {
        this.carDao.update(car);
    }

    @Override
    @Transactional
    public void remove(long id) {
        this.carDao.remove(id);
    }

    @Override
    @Transactional
    public Car getById(long id) {
        return this.carDao.getById(id);
    }

    @Override
    @Transactional
    public List<Car> getAll() {
        return this.carDao.getAll();
    }
}
