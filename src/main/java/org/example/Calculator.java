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
    public static double power(double base, double exponent) {
    return Math.pow(base, exponent);
}

public static double squareRoot(double num) {
    if (num < 0) throw new ArithmeticException("Square root of negative number");
    return Math.sqrt(num);
}

public static double logarithm(double num) {
    if (num <= 0) throw new ArithmeticException("Logarithm of non-positive number");
    return Math.log(num);
}

public static double factorial(double num) {
    if (num < 0) throw new ArithmeticException("Factorial of negative number");

    double result = 1;
    for (int i = 1; i <= num; i++) {
        result *= i;
    }
    return result;
}

public static void main(String[] args) {

    java.util.Scanner scanner = new java.util.Scanner(System.in);
    int choice;

    do {
        System.out.println("\nScientific Calculator");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Power");
        System.out.println("6. Square Root");
        System.out.println("7. Logarithm");
        System.out.println("8. Factorial");
        System.out.println("9. Exit");

        System.out.print("Enter choice: ");
        choice = scanner.nextInt();

        double a, b;

        switch (choice) {

            case 1:
                System.out.print("Enter two numbers: ");
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                System.out.println("Result: " + add(a, b));
                break;

            case 2:
                System.out.print("Enter two numbers: ");
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                System.out.println("Result: " + sub(a, b));
                break;

            case 3:
                System.out.print("Enter two numbers: ");
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                System.out.println("Result: " + mul(a, b));
                break;

            case 4:
                System.out.print("Enter two numbers: ");
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                System.out.println("Result: " + div(a, b));
                break;

            case 5:
                System.out.print("Enter base and exponent: ");
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                System.out.println("Result: " + power(a, b));
                break;

            case 6:
                System.out.print("Enter number: ");
                a = scanner.nextDouble();
                System.out.println("Result: " + squareRoot(a));
                break;

            case 7:
                System.out.print("Enter number: ");
                a = scanner.nextDouble();
                System.out.println("Result: " + logarithm(a));
                break;

            case 8:
                System.out.print("Enter number: ");
                a = scanner.nextDouble();
                System.out.println("Result: " + factorial(a));
                break;

            case 9:
                System.out.println("Exiting calculator...");
                break;

            default:
                System.out.println("Invalid choice");
        }

    } while (choice != 9);

    scanner.close();
}
}
