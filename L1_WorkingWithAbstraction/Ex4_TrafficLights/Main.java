package L1_WorkingWithAbstraction.Ex4_TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lights[] lights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(light -> Lights.valueOf(light)).toArray(Lights[]::new);

        int numberOfUpdates = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfUpdates ; i++) {
            updateLights(lights);

            printLights(lights);
        }
    }

    private static void updateLights(Lights[] lights) {
        //Lights light - променливата е копие на реалната стойност в тази структура от данни
       /* for (Lights light : lights) {
            switch (light){
                case RED -> light = Lights.GREEN;
                case GREEN -> light = Lights.YELLOW;
                case YELLOW -> light = Lights.RED;
            }
        }*/

        for (int i = 0; i < lights.length; i++) {
            switch (lights[i]){
                case RED -> lights[i] = Lights.GREEN;
                case GREEN -> lights[i] = Lights.YELLOW;
                case YELLOW -> lights[i] = Lights.RED;
            }
        }

    }

    private static void printLights(Lights[] lights) {
        Arrays.stream(lights).forEach(light -> System.out.print(light + " "));
        System.out.println();
    }
}
