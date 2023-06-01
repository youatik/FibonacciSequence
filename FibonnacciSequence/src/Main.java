import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        scanner.close();

        int result = Fibonacci.fibonacci(n);
        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }
}
