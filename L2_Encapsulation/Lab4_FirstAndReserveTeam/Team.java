package Lab4_FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.setName(name);
        this.setFirstTeam(new ArrayList<>());
        this.setReserveTeam(new ArrayList<>());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    public void setFirstTeam(List<Person> firstTeam) {
        this.firstTeam = firstTeam;
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }

    public void setReserveTeam(List<Person> reserveTeam) {
        this.reserveTeam = reserveTeam;
    }

    public void addPlayer(Person person) {
        if (person.getAge() < 40) {
            //не използваме getter, защото той връща списък, който не може да се променя
            this.firstTeam.add(person);
        } else {
            this.reserveTeam.add(person);
        }
    }
}
