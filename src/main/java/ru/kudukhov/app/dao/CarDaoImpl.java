package ru.kudukhov.app.dao;

import ru.kudukhov.app.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CarDaoImpl implements CarDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        Session em = this.sessionFactory.getCurrentSession();
        em.persist(car);
    }

    @Override
    public void update(Car car) {
        Session em = this.sessionFactory.getCurrentSession();
        em.merge(car);
    }

    @Override
    public void remove(long id) {
        Session em = this.sessionFactory.getCurrentSession();
        Car carToBeRemoved = em.getReference(Car.class, id);

        if (carToBeRemoved != null) {
            em.remove(carToBeRemoved);
        }
    }

    @Override
    public Car getById(long id) {
        Session em = this.sessionFactory.getCurrentSession();
        return em.find(Car.class, id);
    }

    @Override
    public List<Car> getAll() {
        Session em = this.sessionFactory.getCurrentSession();
        return em.createQuery("SELECT b FROM Car b", Car.class).getResultList();
    }
}
