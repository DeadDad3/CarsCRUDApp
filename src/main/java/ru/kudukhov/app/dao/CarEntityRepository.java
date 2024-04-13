package ru.kudukhov.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kudukhov.app.model.Car;

import java.util.List;

@Repository
public interface CarEntityRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByCategory(Long category);
}
