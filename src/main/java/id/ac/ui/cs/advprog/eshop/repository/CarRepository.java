package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class CarRepository {
    static int id = 0;
    private List<Car> carData = new ArrayList<>();
    public Car create(Car car){
        if(car.getCarId() == null) {
            UUID uuid = UUID.randomUUID();
            car.setCarId(uuid.toString());
        }
        carData.add(car);
        return car;
    }
    public Iterator<Car> findAll(){
        return carData.iterator();
    }
    public Car findById(int id){
        for (Car car : carData) {
            if (car.getCarId().equals(id)) {
                return car;
            }
        }
        return null;
    }
    public Car update(String id, Car updateCar){
        for (int i = 0; i < carData.size(); i++) {
            Car car = carData.get(i);
            if (car.getCarId().equals(id)) {
                // update existing car with new information
                car.setCarName(updateCar.getCarName());
                car.setCarColor(updateCar.getCarColor());
                car.setCarQuality(updateCar.getCarQuality());
                return car;
            }
        }
        return null;
    }
    public void delete(String id){ carData.removeIf(car -> car.getCarId().equals(id));}
}
