package fr.campus.car.server.dao;

import fr.campus.car.server.model.Car;

import java.util.List;

public interface CarDao {

    public List<Car> findAll();
    public Car findById(int id);
    public Car save(Car car);
    public Car update(int id, Car car);
    public Car delete(int id);


}
