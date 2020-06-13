package pl.sood.springsecurity2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sood.springsecurity2.model.Car;
import pl.sood.springsecurity2.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {


    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public Iterable<Car> getAll() {
        return carService.findAll();
    }

    @GetMapping
    public Optional<Car> getById(@RequestParam Long index) {
        return carService.findById(index);
    }

    @PostMapping
    public Car addVideo(@RequestBody Car videoCassette) {
        return  carService.save(videoCassette);
    }

    @PutMapping
    public Car updateVideo(@RequestBody Car videoCassette) {
        return carService.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index) {
        carService.deleteById(index);
    }
}
