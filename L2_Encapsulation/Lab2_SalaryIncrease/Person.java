package Lab2_SalaryIncrease;

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
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
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
