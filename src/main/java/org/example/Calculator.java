package org.example;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double mul(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }

    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("Usage: <operation> <num1> <num2>");
            System.out.println("Example: add 10 5");
            return;
        }

        String operation = args[0];
        double a = Double.parseDouble(args[1]);
        double b = Double.parseDouble(args[2]);

        switch (operation.toLowerCase()) {

            case "add":
                System.out.println("Result: " + add(a, b));
                break;

            case "sub":
                System.out.println("Result: " + sub(a, b));
                break;

            case "mul":
                System.out.println("Result: " + mul(a, b));
                break;

            case "div":
                System.out.println("Result: " + div(a, b));
                break;

            default:
                System.out.println("Invalid operation. Use: add, sub, mul, div");
        }
    }
}
