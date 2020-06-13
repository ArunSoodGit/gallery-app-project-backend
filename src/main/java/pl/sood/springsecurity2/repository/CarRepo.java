package pl.sood.springsecurity2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sood.springsecurity2.model.Car;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {
}
