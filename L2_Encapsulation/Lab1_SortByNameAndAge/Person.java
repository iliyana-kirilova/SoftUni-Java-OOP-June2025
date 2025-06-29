package L2_Encapsulation.Lab1_SortByNameAndAge;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString(){//представя обекта под формата на текст
        return String.format("%s %s is %d years old.", this.firstName, this.lastName, this.age);

    }
}
