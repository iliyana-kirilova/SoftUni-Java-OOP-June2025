package ExamPrep.competition.core;

//TODO - Implement all the methods

import ExamPrep.competition.common.ExceptionMessages;
import ExamPrep.competition.entities.car.*;
import ExamPrep.competition.entities.competition.Competition;
import ExamPrep.competition.entities.competition.CompetitionImpl;
import ExamPrep.competition.entities.destination.Destination;
import ExamPrep.competition.entities.destination.Lake;
import ExamPrep.competition.entities.destination.Mountain;
import ExamPrep.competition.entities.destination.SeaSide;
import ExamPrep.competition.entities.repositories.DestinationRepository;
import ExamPrep.competition.entities.repositories.Repository;

import java.util.Collection;
import java.util.List;

import static ExamPrep.competition.common.ConstantMessages.*;
import static ExamPrep.competition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private final Repository<Destination> destinationRepository;

    public ControllerImpl() {
        this.destinationRepository = new DestinationRepository();
    }

    @Override
    public String addDestination(String destinationType, String destinationName) {
        Destination dest;
        switch (destinationType){
            case "Lake"-> dest = new Lake(destinationName);
            case "Mountain"-> dest = new Mountain(destinationName);
            case "SeaSide" -> dest = new SeaSide(destinationName);
            default -> throw new IllegalArgumentException(INVALID_DESTINATION);
        }

        Destination destination = destinationRepository.byName(destinationName);
        if (destination!=null){
            throw new IllegalArgumentException(EXISTING_DESTINATION);
        }

        destinationRepository.add(dest);
        return String.format(DESTINATION_ADDED, destinationType, destinationName);
    }

    @Override
    public String addCar(String destinationName, String carBrand, String carModel) {
        //проверяваме дали дестинацията съществува
        Destination destination = destinationRepository.byName(destinationName);
        if (destination==null){
            throw  new NullPointerException(ExceptionMessages.NON_EXISTING_DESTINATION);
        }

        //проверяваме дали марката кола съществува
        if (!carBrand.equals("Tesla")&& !carBrand.equals("VW")&&
                !carBrand.equals("Hyundai") && !carBrand.equals("Dacia")){
            throw new IllegalArgumentException(INVALID_CAR);
        }

        //проверяваме за уникалност на колата
        boolean carExists = destination.getCars().stream()
                .anyMatch(car -> car.getModel().equals(carModel));

        if (carExists){
            throw new IllegalArgumentException(EXISTING_CAR_BRAND_AND_MODEL );
        }

        Car car;
        switch (carBrand){
            case "Tesla"->{
                car = new Tesla(carModel);
                destination.getCars().add(car);
            }
            case "VW"->{
                car = new VW(carModel);
                destination.getCars().add(car);
            }
            case "Hyundai"->{
                car = new Hyundai(carModel);
                destination.getCars().add(car);
            }
            case "Dacia"->{
                car = new Dacia(carModel);
                destination.getCars().add(car);
            }
        }

        return String.format(CAR_ADDED, carBrand, carModel);
    }

    @Override
    public String reachDestination(String destinationName) {
        //извиквам дестинацията
        Destination destination = destinationRepository.byName(destinationName);

        //взимам всички коли от дестинацията
        Collection<Car> cars = destination.getCars();

        StringBuilder sb = new StringBuilder();

        //Създавам състезанието и го стартирам.
        Competition competition = new CompetitionImpl();
        competition.startVoyage(destination, cars);

        //създавам списък на колите, които са отпаднали
        List<Car> unfinishedCars = getUnfinishedCars(destination);
        sb.append(String.format(VOYAGE_OVER, destinationName, unfinishedCars.size()));

        return sb.toString();
    }

    private List<Car> getUnfinishedCars(Destination destination) {
        return destination.getCars().stream()
                .filter(car -> (car.getMileage() < destination.getDistance() && car.getBatteryCapacity() <= 0)
                        || (car.getMileage() < destination.getDistance() && car.getBatteryCapacity() < 15))
                .toList();
    }

    @Override
    public String getStatistics() {
        StringBuilder build = new StringBuilder();
        //взима всички дестинации добавени до момента
        Collection<Destination> destinations = destinationRepository.getCollection();

        //за всяка дестинация, разглеждам колите които участвали
        for (Destination destination : destinations) {
            build.append(String.format(CARS_TOOK_PART, destination.getName())).append(System.lineSeparator());
            for (Car car : destination.getCars()) {
                extracted(car, build); // метода показва данните за всяка една кола
            }
        }

        return build.toString();
    }

    private void extracted(Car car, StringBuilder build) {
        build.append(String.format(FINAL_CAR_INFO,
                car.getClass().getSimpleName(),
                car.getModel(),
                car.getBatteryCapacity(),
                car.getMileage())).append(System.lineSeparator());
    }
}
