package Lab4_HotelReservation;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //входни данни
        String[] data = scanner.nextLine().split("\\s+");
        //"50.25 5 Summer VIP".split -> ["50.25", "5", "Summer", "VIP"]
        double pricePerDay = Double.parseDouble(data[0]); //цена за 1 нощувка
        int days = Integer.parseInt(data[1]); //дни
        String seasonStr = data[2]; //сезон -> "Spring", "Summer", "Autumn", "Winter"
        String discount = data[3]; //вид отстъпка -> "VIP", "SecondVisit", "None"

        //работа с Enum
        Season season = Season.valueOf(seasonStr.toUpperCase(Locale.ROOT));
        DiscountType discountType = DiscountType.NONE;
        if (discount.equals("VIP")) {
            discountType = DiscountType.VIP;
        } else if (discount.equals("SecondVisit")) {
            discountType = DiscountType.SECOND_VISIT;
        }

        //изчисляване на крайната цена
        double finalPrice = pricePerDay * days * season.getMultiplier() * discountType.getPercent();
        System.out.printf("%.2f", finalPrice);

    }
}
