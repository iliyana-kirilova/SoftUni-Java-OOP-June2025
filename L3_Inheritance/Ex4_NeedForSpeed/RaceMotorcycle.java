package L3_Inheritance.Ex4_NeedForSpeed;

public class RaceMotorcycle extends Motorcycle{
    private static final double DEFAULT_FUEL_CONSUMPTION = 8;

    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
