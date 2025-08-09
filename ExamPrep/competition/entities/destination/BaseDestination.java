package ExamPrep.competition.entities.destination;

import ExamPrep.competition.entities.car.Car;

import java.util.ArrayList;
import java.util.Collection;

import static ExamPrep.competition.common.ExceptionMessages.DESTINATION_NAME_NULL_OR_EMPTY;
import static ExamPrep.competition.common.ExceptionMessages.NEGATIVE_DISTANCE_VALUE;

public abstract class BaseDestination implements Destination {
    private String name;
    private int distance;
    private Collection<Car> cars;

    public BaseDestination(String name, int distance) {
        this.setName(name);
        this.setDistance(distance);
        this.cars = new ArrayList<>();
    }

    @Override
    public Collection<Car> getCars() {
        return this.cars;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    public void setName(String name) {
        if (name==null || name.trim().isEmpty()){
            throw new NullPointerException(DESTINATION_NAME_NULL_OR_EMPTY);
            //ExceptionMessages.DESTINATION_NAME_NULL_OR_EMPTY
        }
        this.name = name;
    }

    public void setDistance(int distance) {
        if (distance<0){
            throw new IllegalArgumentException(NEGATIVE_DISTANCE_VALUE);
        }
        this.distance = distance;
    }
}
