package ExamPrep.picking.core;

import ExamPrep.picking.entities.action.Action;
import ExamPrep.picking.entities.action.ActionImpl;
import ExamPrep.picking.entities.pickers.ExperiencedPicker;
import ExamPrep.picking.entities.pickers.JuniorPicker;
import ExamPrep.picking.entities.pickers.Picker;
import ExamPrep.picking.entities.places.Place;
import ExamPrep.picking.entities.places.PlaceImpl;
import ExamPrep.picking.repositories.PlaceRepository;
import ExamPrep.picking.repositories.Repository;

import java.util.Collection;
import java.util.List;

import static ExamPrep.picking.common.ConstantMessages.*;
import static ExamPrep.picking.common.ExceptionMessages.*;

//TODO - Implement all the methods
public class ControllerImpl implements Controller {

    private final Repository<Place> placeRepository;

    public ControllerImpl() {
        this.placeRepository = new PlaceRepository();
    }

    @Override
    public String addPlace(String placeName, String... mushrooms) {
        Place place = new PlaceImpl(placeName);
        place.getMushrooms().addAll(List.of(mushrooms));
        this.placeRepository.add(place);
        return String.format(PLACE_ADDED, placeName);
    }

    @Override
    public String addPicker(String placeName, String pickerType, String pickerName) {
        //Взимаме обекта Място от хранилището по дадено име.
        Place place = placeRepository.byName(placeName);

        //Проверявам дали вече съществува събирач с даденото име в списъка на текущото място
        Picker pickerByName = place.getPickers()
                            .stream()
                            .filter(picker -> picker.getName().equals(pickerName))
                            .findFirst().orElse(null);

        //Ако такъв вече съществува, хвърляме изключение
        if (pickerByName != null) {
            throw new IllegalArgumentException(EXISTING_PICKER);
        }

        //Създаваме нов събирач в зависимост от типа, подаден като параметър
        Picker picker = switch (pickerType) {
            case "JuniorPicker" -> new JuniorPicker(pickerName);         // ако е Junior, създаваме JuniorPicker
            case "ExperiencedPicker" -> new ExperiencedPicker(pickerName); // ако е Experienced, създаваме ExperiencedPicker
            default -> throw new IllegalArgumentException(INVALID_PICKER); // ако типът не е валиден — хвърляме изключение
        };

        // Добавяме новия към списъка с Pickers в съответното място
        place.getPickers().add(picker);

        //Връщаме съобщение, че събирачът е успешно добавен
        return String.format(PICKER_ADDED, pickerType, pickerName);
    }

    @Override
    public String startPicking(String placeName) {
        //Взимаме обекта Място от хранилището по дадено име.
        Place place = this.placeRepository.byName(placeName);

        //Ако мястото е развно на нищо, хвърляме изключение
        if (place==null){
            throw new NullPointerException(String.format(NON_EXISTING_PLACE, placeName));
        }

        //Създаваме обекта Действие, което съдържа метода startPicking
        Action action = new ActionImpl();
        action.startPicking(place);

        //Връщаме съобщение, за местата на събиране
        return String.format(PLACE_VISITED, placeName);
    }

    @Override
    public String getStatistics() {
        StringBuilder build = new StringBuilder();
        Collection<Place> places = placeRepository.getCollection();

        for (Place place : places) {
            build.append(String.format("Pickers in the %s:", place.getName()))
                    .append(System.lineSeparator());
            for (Picker picker : place.getPickers()) {
                Collection<String> pickerMushrooms = picker.getBag().getMushrooms();
                build.append(String.format("""
                                Name: %s
                                Vitality: %d
                                Bag mushrooms: %s
                                """, picker.getName(),
                        picker.getVitality(),
                        !pickerMushrooms.isEmpty() ? String.join(", ", pickerMushrooms) : "none"));
            }
        }

        return build.toString();
    }
}
