import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        //scanner.close();

        System.out.print("Choose the Fibonacci version (1 for iterative, 2 for recursive): ");
        int choice = scanner.nextInt();

        int result;
        if (choice == 1) {
            result = Fibonacci.fibonacci(n);
        } else if (choice == 2) {
            result = FibonacciRecursive.fibonacciRecursive(n);
        } else {
            System.out.println("Invalid choice. Please choose 1 or 2.");
            return;
        }

        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }
}

