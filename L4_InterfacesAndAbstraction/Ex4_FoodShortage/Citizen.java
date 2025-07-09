package L4_InterfacesAndAbstraction.Ex4_FoodShortage;

public class Citizen implements Person, Identifiable, Buyer{
    private String name;
    private int age;
    private String id;
    private String birthDay;
    private int food;

    public Citizen(String name, int age, String id, String birthDay) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthDay(birthDay);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setFood(int food) {
        this.food = food;
    }

    @Override
    public void buyFood() {
            this.food+=10;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
