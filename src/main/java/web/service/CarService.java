package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> car;

    public CarService() {
        car = new ArrayList<>();
        car.add(new Car("BMW", 1970, 200));
        car.add(new Car("Lotus", 1955, 250));
        car.add(new Car("Dodge", 1980, 190));
        car.add(new Car("Mercedes", 1995, 210));
        car.add(new Car("Lada", 1998, 180));
        car.add(new Car("Opel", 1987, 220));
    }

    public List<Car> getCars(int count) {
        if(count >= car.size()) {
            return car;
        } else {
            return car.subList(0, count);
        }
    }
}
