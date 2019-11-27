package fr.campus.car.server.dao;

import fr.campus.car.server.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao extends JpaRepository<Car, Integer> {
    public List<Car> findAll();
    public Car findById(int id);
    public Car save(Car car);
    public Car update(int id, Car car);
    public Car delete(int id);
}
