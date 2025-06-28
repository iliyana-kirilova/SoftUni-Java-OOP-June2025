package L1_WorkingWithAbstraction.Ex4_TrafficLights;

public enum COLOR {
    RED("GREEN"),
    GREEN("YELLOW"),
    YELLOW("RED");

    private String color;

    COLOR(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
