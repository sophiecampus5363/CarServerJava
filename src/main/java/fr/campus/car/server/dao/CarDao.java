package fr.campus.car.server.dao;

import fr.campus.car.server.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao extends JpaRepository<Car, Integer> {

}




