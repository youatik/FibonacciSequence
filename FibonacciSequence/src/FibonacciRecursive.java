import java.util.ArrayList;
import java.util.List;

public class FibonacciRecursive implements Fibonacci {
    @Override
    public List<Long> getFibonacciSequence(int n) {
        List<Long> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(calculateFibonacci(i));
        }
        return result;
    }

    private long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }
}
