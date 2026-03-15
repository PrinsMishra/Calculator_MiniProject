package org.example;

import java.util.*;

public class Calculator {

    // Basic operations
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
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // Scientific functions
    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Negative input");
        }
        return Math.sqrt(a);
    }

    public static double log(double a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Log undefined for <= 0");
        }
        return Math.log(a);
    }

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative factorial not allowed");
        }

        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.nextLine(); 

        while (true) {

            System.out.println("\n--- Scientific Calculator ---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Power");
            System.out.println("6. Square Root");
            System.out.println("7. Log");
            System.out.println("8. Factorial");
            System.out.println("9. Exit");

            System.out.print("Enter choice (1-9): ");
            int choice;
            try {
                choice = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
                sc.next(); // clear the bad input
                continue;
            }

            if (choice == 9) {
                System.out.println("Exiting...");
                break;
            }

            double a, b;

            switch (choice) {

                case 1:
                    System.out.print("Enter first number: ");
                    a = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    b = sc.nextDouble();
                    System.out.println("Result: " + add(a, b));
                    break;

                case 2:
                    System.out.print("Enter first number: ");
                    a = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    b = sc.nextDouble();
                    System.out.println("Result: " + sub(a, b));
                    break;

                case 3:
                    System.out.print("Enter first number: ");
                    a = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    b = sc.nextDouble();
                    System.out.println("Result: " + mul(a, b));
                    break;

                case 4:
                    System.out.print("Enter first number: ");
                    a = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    b = sc.nextDouble();
                    System.out.println("Result: " + div(a, b));
                    break;

                case 5:
                    System.out.print("Enter base: ");
                    a = sc.nextDouble();
                    System.out.print("Enter exponent: ");
                    b = sc.nextDouble();
                    System.out.println("Result: " + power(a, b));
                    break;

                case 6:
                    System.out.print("Enter number: ");
                    a = sc.nextDouble();
                    System.out.println("Result: " + sqrt(a));
                    break;

                case 7:
                    System.out.print("Enter number: ");
                    a = sc.nextDouble();
                    System.out.println("Result: " + log(a));
                    break;

                case 8:
                    System.out.print("Enter integer: ");
                    int n = sc.nextInt();
                    System.out.println("Result: " + factorial(n));
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
