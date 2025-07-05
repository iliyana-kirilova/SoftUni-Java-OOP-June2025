package L3_Inheritance.Lab3_RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();
        randomArrayList.add(9);
        randomArrayList.add(5);
        randomArrayList.add(7);
        randomArrayList.add(65);
        randomArrayList.getLast();
        randomArrayList.getRandomElement();
    }
}
