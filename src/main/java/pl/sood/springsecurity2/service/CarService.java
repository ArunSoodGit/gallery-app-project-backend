package pl.sood.springsecurity2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.sood.springsecurity2.model.Car;
import pl.sood.springsecurity2.repository.CarRepo;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CarService {

    private CarRepo carRepo;

    @Autowired

    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Optional<Car> findById(Long id) {
        return carRepo.findById(id);
    }

    public Iterable<Car> findAll() {
        return carRepo.findAll();
    }

    public Car save(Car car) {
        return carRepo.save(car);
    }

    public void deleteById(Long id) {
        carRepo.deleteById(id);
    }



}

