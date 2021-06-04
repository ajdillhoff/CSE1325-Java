/**
 * Using variables in Java programs.
 * @version 1.0
 * @author Alex Dillhoff
 */
public class VariableExample {
    public static void main(String[] args) {
        // It is good practice to initialize all variables.
        double velocity = 59.3;
        System.out.printf("Velocity: %.1f\n", velocity);

        // Attempting to use an unitialized variable will leads to errors.
        //int age;
        //System.out.println(age);
    }
}
