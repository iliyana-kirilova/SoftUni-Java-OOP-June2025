package Lab3_Animals;

public class Cat extends Animal{
    public Cat(String name, String favouriteFood) {
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
                .append("MEEOW");
        return sb.toString();
    }
}
