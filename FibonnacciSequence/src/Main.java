import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import fibonacci.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FibonacciComposite fibonacciComposite = new FibonacciComposite();

        Scanner scanner = new Scanner(System.in);
        int n = 0;

        while (n != -1) {
            System.out.print("Enter the value of n (-1 to exit): ");
            n = scanner.nextInt();

            if (n == -1) {
                break;
            }

            fibonacciComposite.clearFibonacciObjects();

            FibonacciInterface fibonacci = new Fibonacci();
            FibonacciInterface fibonacciRecursive = new FibonacciRecursive();

            fibonacciComposite.addFibonacciObject(fibonacci);
            fibonacciComposite.addFibonacciObject(fibonacciRecursive);

            long result = fibonacciComposite.fibonacci(n);

            if (result == -1) {
                System.out.println("Results are not equal");
            } else {
                System.out.println("The Fibonacci result is: " + result);
            }

            List<Long> fibonacciSequence = fibonacci.getFibonacciSequence();
            System.out.println("Fibonacci sequence: " + fibonacciSequence);

             }
    }
}
