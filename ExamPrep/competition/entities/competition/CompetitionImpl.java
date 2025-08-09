package ExamPrep.competition.entities.competition;

import ExamPrep.competition.entities.car.Car;
import ExamPrep.competition.entities.destination.Destination;

import java.util.Collection;

public class CompetitionImpl implements Competition{
    @Override
    public void startVoyage(Destination destination, Collection<Car> cars) {
        for (Car car : destination.getCars()) {
            while (car.getMileage()<destination.getDistance()){
                if (car.getBatteryCapacity()<15 || car.getBatteryCapacity() <= 0){
                    break;
                }
                car.drive();
            }
        }
    }
}
