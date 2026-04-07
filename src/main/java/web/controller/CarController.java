package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import java.util.List;


@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCar(@RequestParam(value = "count", required = false) Integer count, ModelMap modelMap) {
        int displayCount = (count == null) ? 5 : count;
        List<Car> car = carService.getCars(displayCount);
        modelMap.addAttribute("cars", car);
        return "car";
    }
}
