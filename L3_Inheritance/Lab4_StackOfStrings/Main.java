package L3_Inheritance.Lab4_StackOfStrings;

public class Main {
    public static void main(String[] args) {

        StackOfStrings stackOfStrings = new StackOfStrings();
        stackOfStrings.push("one");
        stackOfStrings.push("two");
        stackOfStrings.push("three");
        stackOfStrings.push("four");
        stackOfStrings.push("five");

        System.out.println(stackOfStrings.pop());
        System.out.println(stackOfStrings.peek());
        System.out.println(stackOfStrings.isEmpty());
    }
}
