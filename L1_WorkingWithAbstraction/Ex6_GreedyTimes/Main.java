package L1_WorkingWithAbstraction.Ex6_GreedyTimes;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safeTreasure = scanner.nextLine().split("\\s+");

        Map<String, Map<String, Long>> bag = new LinkedHashMap<>();
        long totalGold = 0, totalGems = 0, totalCash = 0;
        long currentBagTotal = 0;

        for (int i = 0; i < safeTreasure.length; i += 2) {
            String item = safeTreasure[i];
            long quantity = Long.parseLong(safeTreasure[i + 1]);

            String itemType = getItemType(item);
            if (itemType == null) {
                continue;
            }

            if (currentBagTotal + quantity > bagCapacity) {
                continue;
            }

            if (itemType.equals("Gem")) {
                if (totalGems + quantity > totalGold) {
                    continue;
                }
            }


            if (itemType.equals("Cash")) {
                if (totalCash + quantity > totalGems) {
                    continue;
                }
            }


            bag.putIfAbsent(itemType, new LinkedHashMap<>());
            bag.get(itemType).put(item,
                    bag.get(itemType).getOrDefault(item, 0L) + quantity);


            currentBagTotal += quantity;

            switch (itemType) {
                case "Gold" -> totalGold += quantity;
                case "Gem" -> totalGems += quantity;
                case "Cash" -> totalCash += quantity;
            }
        }


        for (Map.Entry<String, Map<String, Long>> entry : bag.entrySet()) {
            long categoryTotal = entry.getValue().values().stream()
                    .mapToLong(Long::longValue).sum();
            System.out.printf("<%s> $%d%n", entry.getKey(), categoryTotal);

            entry.getValue().entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByKey().reversed())
                    .forEach(e -> System.out.printf("##%s - %d%n", e.getKey(), e.getValue()));


        }

    }


    private static String getItemType(String item) {
        if (item.length() == 3) return "Cash";
        if (item.toLowerCase().endsWith("gem")) return "Gem";
        if (item.equalsIgnoreCase("gold")) return "Gold";
        return null;
    }

}