package fibonacci;
import java.util.ArrayList;
import java.util.List;


public class Fibonacci implements FibonacciInterface {
    private List<Long> fibonacciSequence;

    public Fibonacci() {
        fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(0L); // Adding the initial Fibonacci value of 0
        fibonacciSequence.add(1L); // Adding the initial Fibonacci value of 1
    }


    private long calculate(int n) {
        if (n < fibonacciSequence.size()) {
            return fibonacciSequence.get(n);
        }

        for (int i = fibonacciSequence.size(); i <= n; i++) {
            long fibValue = fibonacciSequence.get(i - 1) + fibonacciSequence.get(i - 2);
            fibonacciSequence.add(fibValue);
        }

        return fibonacciSequence.get(n);
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
