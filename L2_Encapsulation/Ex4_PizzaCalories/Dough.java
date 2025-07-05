package Ex4_PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        switch (flourType) {
            case "White", "Wholegrain" -> this.flourType = flourType;
            default -> throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique){
            case "Crispy", "Chewy", "Homemade" -> this.bakingTechnique = bakingTechnique;
            default -> throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setWeight(double weight) {
        if(weight > 0 && weight <= 200){
            this.weight = weight;
        }else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories(){
        double flourTypeCoefficient = 0;
        switch (this.flourType){
            case "White" -> flourTypeCoefficient = 1.5;
            case "Wholegrain" -> flourTypeCoefficient = 1.0;
        }

        double backingTechnicCoefficient = 0;
        switch (this.bakingTechnique){
            case "Crispy" -> backingTechnicCoefficient = 0.9;
            case "Chewy" -> backingTechnicCoefficient = 1.1;
            case "Homemade" -> backingTechnicCoefficient = 1.0;
        }

        return 2 * this.weight * backingTechnicCoefficient * flourTypeCoefficient;
    }
}
