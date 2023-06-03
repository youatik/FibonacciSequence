package fibonacci;

public class Fibonacci implements FibonacciInterface {
    private int calculate(int n) {
        if (n <= 1) {
            return n;
        }

        int prev = 0;
        int curr = 1;

        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    @Override
    public int fibonacci(int n) {
        return calculate(n);
    }
}

