package fibonacci;
import java.util.ArrayList;
import java.util.List;


public class FibonacciRecursive implements FibonacciInterface {
    private List<Long> fibonacciSequence;

    public FibonacciRecursive() {
        fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(0L); // Adding the initial Fibonacci value of 0
        fibonacciSequence.add(1L); // Adding the initial Fibonacci value of 1
    }

    private long calculate(int n) {
        if (n < fibonacciSequence.size()) {
            return fibonacciSequence.get(n);
        }

        long fibValue = calculate(n - 1) + calculate(n - 2);
        fibonacciSequence.add(fibValue);

        return fibValue;
    }


    @Override
    public long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }

        return calculate(n);
    }


    public List<Long> getFibonacciSequence() {
        return fibonacciSequence;
    }
}
