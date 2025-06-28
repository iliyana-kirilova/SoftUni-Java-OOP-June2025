package Lab4_HotelReservation;

public enum DiscountType {
    VIP(0.8), //20% oтстъпка -> 0.20
    SECOND_VISIT(0.9), //10% отстъпка -> 0.10
    NONE(1.00); //0% остъпка -> 0.0

    private double percent;

    DiscountType (double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return this.percent;
    }

}
