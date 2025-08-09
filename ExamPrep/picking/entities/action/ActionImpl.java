package ExamPrep.picking.entities.action;

import ExamPrep.picking.entities.pickers.Picker;
import ExamPrep.picking.entities.places.Place;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ActionImpl implements Action{


    @Override
    public void startPicking(Place place) {
        // Вземаме колекцията от гъби от дадено място
        Collection<String> mushrooms = place.getMushrooms();
        // Създаваме списък с всички събирачи (Picker-и) от мястото
        List<Picker> pickers = new ArrayList<>(place.getPickers()); //от мястото вземам всички събирачи


        for (Picker picker : pickers) {
            // Докато събирачът има енергия (vitality > 0) и все още има гъби за събиране
            while (picker.getVitality() > 0 && mushrooms.iterator().hasNext()) {

                // Взимаме следващата гъба от колекцията
                String currentMushroom = mushrooms.iterator().next();

                picker.pick();
                // Проверяваме дали гъбата е отровна (започва с "poisonous")
                if (currentMushroom.startsWith("poisonous")) {
                    // Ако е отровна – изпразваме торбата с гъби на събирача
                    picker.getBag().getMushrooms().clear();
                } else {
                    // Ако не е отровна – добавяме гъбата в торбата на събирача
                    picker.getBag().getMushrooms().add(currentMushroom);
                }

                // Премахваме гъбата от мястото – вече е събрана
                mushrooms.remove(currentMushroom);
            }

        }
    }
}
