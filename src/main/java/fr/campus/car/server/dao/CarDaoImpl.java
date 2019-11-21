package fr.campus.car.server.dao;
import fr.campus.car.server.model.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CarDaoImpl implements CarDao {
        public static List<Car> cars = new ArrayList<>();
        static {
            cars.add(new Car(1, "Tesla", "Model S"));
            cars.add(new Car(2,"Audi", "A3"));
            cars.add(new Car(3, "Renault", "Clio IV"));
        }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public Car findById(int id) {
        for (Car car : cars) {
            if(car.getId() == id){
                return car;
            }
        }
        return null;
    }

    @Override
    public Car save(Car car) {
        cars.add(car);
        return null;
    }
}
