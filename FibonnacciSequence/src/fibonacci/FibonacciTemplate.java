package fibonacci;

import java.util.ArrayList;
import java.util.List;

public abstract class FibonacciTemplate implements FibonacciInterface {
    protected List<Long> fibonacciSequence;

    public FibonacciTemplate() {
        fibonacciSequence = new ArrayList<>();
        fibonacciSequence.add(0L); // Adding the initial Fibonacci value of 0
        fibonacciSequence.add(1L); // Adding the initial Fibonacci value of 1
    }

    protected long calculate(int n) {
        if (n < fibonacciSequence.size()) {
            return fibonacciSequence.get(n);
        }

        for (int i = fibonacciSequence.size(); i <= n; i++) {
            long fibValue = generateFibonacci(i);
            fibonacciSequence.add(fibValue);
        }

        return fibonacciSequence.get(n);
    }

    protected abstract long generateFibonacci(int n);

    public List<Long> getFibonacciSequence() {
        return fibonacciSequence;
    }
}
