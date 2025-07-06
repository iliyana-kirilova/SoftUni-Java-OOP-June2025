package L3_Inheritance.Ex6_Animals;

public class Animal {
    private static final String INVALID_INPUT = "Invalid input!";

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        if(gender.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.gender = gender;
    }

    public String produceSound(){
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s%n", this.getClass().getSimpleName()));
        builder.append(String.format("%s %d %s%n", this.name, this.age, this.gender));
        builder.append(this.produceSound());

        return builder.toString();
    }
}
