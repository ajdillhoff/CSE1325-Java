package edu.uta.CSE1325;

public class EquationParser {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.printf("Not enough arguments!\n");
            return;
        }

        String equation = args[0];

        if (equation.matches("\\d+([+\\-\\*/]\\d+)+=\\d+")) {
            System.out.printf("%s is a valid equation.\n", equation);
        } else {
            System.out.printf("%s is not a valid equation.\n", equation);
        }
    }
}
