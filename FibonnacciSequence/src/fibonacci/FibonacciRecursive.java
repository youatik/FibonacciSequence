package fibonacci;

public class FibonacciRecursive extends FibonacciTemplate {
    @Override
    protected long generateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return calculate(n - 1) + calculate(n - 2);
    }

    @Override
    public long fibonacci(int n) {
        return calculate(n);
    }
}
