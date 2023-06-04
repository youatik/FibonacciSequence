import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import fibonacci.*;
import timing.FibonacciTimingDecorator;

public class Main2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FibonacciInterface fibonacci = new Fibonacci();
        FibonacciInterface fibonacciRecursive = new FibonacciRecursive();

        FibonacciComposite fibonacciComposite = new FibonacciComposite();
        fibonacciComposite.addFibonacciObject(fibonacci);
        fibonacciComposite.addFibonacciObject(fibonacciRecursive);

        Scanner scanner = new Scanner(System.in);
        int n = 0;

        while (n != -1) {
            System.out.print("Enter the value of n (-1 to exit): ");
            n = scanner.nextInt();

            if (n == -1) {
                break;
            }

            long result = fibonacciComposite.fibonacci(n);

            if (result == -1) {
                System.out.println("Results are not equal");
            } else {
                System.out.println("The Fibonacci result is: " + result);
            }
        }
    }
}
