package L3_Inheritance.Ex6_Animals;

public class Dog extends Animal{
    private static final String DOG_SOUND = "Woof!";
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return DOG_SOUND;
    }
}
