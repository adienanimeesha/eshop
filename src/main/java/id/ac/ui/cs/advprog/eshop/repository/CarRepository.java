package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository extends AbstractRepository<Car> implements CarRepositoryInterface {

    public CarRepository() {
        // pass method references for getting and setting the carId
        super(Car::getCarId, Car::setCarId);
    }

    @Override
    protected void updateEntity(Car existing, Car updatedEntity) {
        existing.setCarName(updatedEntity.getCarName());
        existing.setCarColor(updatedEntity.getCarColor());
        existing.setCarQuantity(updatedEntity.getCarQuantity());
    }
}
