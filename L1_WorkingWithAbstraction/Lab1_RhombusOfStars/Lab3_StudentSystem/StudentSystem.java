package L1_WorkingWithAbstraction.Lab1_RhombusOfStars.Lab3_StudentSystem;

import java.util.HashMap;
import java.util.Map;


public class StudentSystem {
    private Map<String, Student> studentMap;

    public StudentSystem() {
        this.studentMap = new HashMap<>();
    }

    public void parseCommand(String[]args) {
        String command = args[0];
        String name = args[1];
        if (command.equals("Create")) {

            int age = Integer.parseInt(args[2]);
            double grade =Double.parseDouble(args[3]);

            studentMap.putIfAbsent(name,new Student(name, age, grade));

        } else if (command.equals("Show")) {
            if (studentMap.containsKey(name)) {
                Student student = studentMap.get(name);
                double grade = student.getGrade();
                String output = String.format("%s is %s years old.",student.getName(),student.getAge());

                if (grade >= 5.00) {
                    output += " Excellent student.";
                } else if (grade < 5.00 && grade >= 3.50) {
                    output += " Average student.";
                } else {
                    output += " Very nice person.";
                }

                System.out.println(output);
            }
        }
    }
}
