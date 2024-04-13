package ru.kudukhov.app.controller;

import ru.kudukhov.app.model.Car;
import ru.kudukhov.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String listCars(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("listCars", this.carService.getAll());
        return "cars";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car, Model model) {
        if (car != null && car.getId() != null) {
            carService.update(car);
        } else {
            carService.add(car);
        }
        model.addAttribute("cars", carService.getAll());
        return "cars";
    }


    @GetMapping("/remove/{id}")
    public String removeCar(@PathVariable long id) {
        this.carService.remove(id);
        return "redirect:/cars";
    }

    @GetMapping("/edit/{id}")
    public String updateCar(@PathVariable long id, Model model) {
        model.addAttribute("car", this.carService.getById(id));
        model.addAttribute("listCars", this.carService.getAll());
        return "cars";
    }

    @GetMapping("/{id}")
    public String CarData(@PathVariable long id, Model model) {
        model.addAttribute("car", this.carService.getById(id));
        return "car";
    }
}