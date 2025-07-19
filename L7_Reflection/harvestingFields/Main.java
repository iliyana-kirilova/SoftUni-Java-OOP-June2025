package L7_Reflection.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();

		Field[] fields = RichSoilLand.class.getDeclaredFields();
		Consumer<Field> printer = field -> System.out.println(String.format("%s %s %s",
				Modifier.toString(field.getModifiers()), //access modifier
									field.getType().getSimpleName(), // field type
									field.getName())); // field name

		while (!input.equals("HARVEST")){
			String currentInput = input;
			Field [] requestedFields = Arrays.stream(fields)
										.filter(field -> Modifier.toString(field.getModifiers()).equals(currentInput)).
										toArray(Field[]::new);



			if (requestedFields.length != 0) {
				Arrays.stream(requestedFields).forEach(printer);
			}else {
				Arrays.stream(fields).forEach(printer);
			}

			input = scanner.nextLine();
		}



	}
}
