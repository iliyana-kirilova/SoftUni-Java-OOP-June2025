package L1_WorkingWithAbstraction.Lab1_RhombusOfStars;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        //общ брой редове = size * 2 - 1
        //горна част на ромба: 1 до средния ред (size)
        //долната част на ромба: средния ред + 1 до последния ред size * 2 - 1

        //принтираме горната част на ромба
        printTopPart(size);

        //принтираме долната част на ромба
        printDownPart(size);
    }

    private static void printDownPart(int size) {
        for (int row = 1; row <= size-1 ; row++) {
            printRepeatingString(" ", row);
            printRepeatingString("* ", size - row);
            System.out.println();
        }
    }

    private static void printTopPart(int size) {
        for (int row = 1; row <=size ; row++) {
            printRepeatingString(" ", size - row);
            printRepeatingString("* ", row);
            System.out.println();
        }
    }

    //принтира даден текст определен брой пъти
    private static void printRepeatingString (String str, int count) {
        for (int i = 1; i <= count; i++) {
            System.out.print(str);
        }
    }
}
