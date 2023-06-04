package fibonacci;

public class Fibonacci extends FibonacciTemplate {
    @Override
    protected long generateFibonacci(int n) {
        return fibonacciSequence.get(n - 1) + fibonacciSequence.get(n - 2);
    }

    @Override
    public long fibonacci(int n) {
        return calculate(n);
    }
}
