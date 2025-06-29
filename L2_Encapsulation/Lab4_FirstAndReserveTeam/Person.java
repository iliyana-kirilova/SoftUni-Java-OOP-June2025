package Lab4_FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setFirstName(String firstName) {
        if (firstName.length()<3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName.length()<3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age<=0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if (salary<460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public  void increaseSalary(double percentBonus){
        if (this.getAge()<30){
            percentBonus/=2;
        }

        double increasedSalary = this.getSalary() + (this.getSalary() * (percentBonus/100));
        this.setSalary(increasedSalary);
    }

    @Override
    public String toString(){//представя обекта под формата на текст
        return String.format("%s %s gets %.2f leva", this.getFirstName(), this.getLastName(), this.getSalary());

    }
}
