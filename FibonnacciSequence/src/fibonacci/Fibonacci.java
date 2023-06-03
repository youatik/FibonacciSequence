package fibonacci;

public class Fibonacci implements FibonacciInterface {
    private int calculate(int n) {
        if (n <= 1)
            return n;
        return calculate(n - 1) + calculate(n - 2);
    }

    @Override
    public int fibonacci(int n) {
        return calculate(n);
    }
}

