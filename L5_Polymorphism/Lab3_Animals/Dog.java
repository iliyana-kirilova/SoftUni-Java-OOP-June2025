package Lab3_Animals;

public class Dog extends Animal{

    public Dog(String name, String favouriteFood){
        super.name = name;
        super.favouriteFood = favouriteFood;
    }

    @Override
    public String explainSelf() {
        StringBuilder sb = new StringBuilder();
        sb.append("I am ")
                .append(super.name)
                .append(" and my favourite food is ")
                .append(super.favouriteFood)
                .append(System.lineSeparator())
                .append("DJAAF");
        return sb.toString();
    }
}
