package L4_InterfacesAndAbstraction.Lab1_CarShop;

public class Seat implements Car{

    private String model;
    private String color;
    private Integer horsePower;
    private String countryProduced;

    public Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.setModel(model);
        this.setColor(color);
        this.setHorsePower(horsePower);
        this.setCountryProduced(countryProduced);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString(){
        return String.format("%s is %s color and have %d horse power",
                this.getModel(), this.getColor(), this.getHorsePower());
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
    }
}
