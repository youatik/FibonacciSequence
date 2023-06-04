import java.util.Scanner;
import fibonacci.*;
import timing.FibonacciTimingDecorator;

public class Main2 {
    public static void main(String[] args) {
        FibonacciInterface fibonacci = new Fibonacci();
        FibonacciInterface fibonacciRecursive = new FibonacciRecursive();

        FibonacciComposite fibonacciComposite = new FibonacciComposite();
        fibonacciComposite.addFibonacciObject(fibonacci);
        fibonacciComposite.addFibonacciObject(fibonacciRecursive);

        int n = 12;

        long result = fibonacciComposite.fibonacci(n);

        if (result == -1) {
            System.out.println("Results are not equal");
        } else {
            System.out.println("The Fibonacci result is: " + result);
        }
    }
}
