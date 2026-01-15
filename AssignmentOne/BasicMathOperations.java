import java.util.Scanner;

class BasicMathOperations {

    // Method to perform addition of two numbers
    static int add(int a, int b) {
        return a + b;
    }

    // Method to perform subtraction of two numbers
    static int subtract(int a, int b) {
        return a - b;
    }

    // Method to perform multiplication of two numbers
    static int multiply(int a, int b) {
        return a * b;
    }

    // Method to perform division of two numbers
    static int divide(int a, int b) {
        return a / b;
    }

    // Method to find remainder of division
    static int remainder(int a, int b) {
        return a % b;
    }

    // Method to calculate square of a number
    static int square(int a) {
        return a * a;
    }

    // Method to calculate cube of a number
    static int cube(int a) {
        return a * a * a;
    }

    // Method to find absolute value of a number
    static int absolute(int a) {
        return Math.abs(a);
    }

    public static void main(String[] args) {

        // Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Reading first integer input
        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        // Reading second integer input
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        // Calling different methods and displaying results
        System.out.println("Addition: " + add(a, b));
        System.out.println("Subtraction: " + subtract(a, b));
        System.out.println("Multiplication: " + multiply(a, b));
        System.out.println("Division: " + divide(a, b));
        System.out.println("Remainder: " + remainder(a, b));
        System.out.println("Square of first number: " + square(a));
        System.out.println("Cube of first number: " + cube(a));
        System.out.println("Absolute of first number: " + absolute(a));
    }
}