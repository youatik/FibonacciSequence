public class FibonacciRecursive implements FibonacciInterface {


    @Override
    public int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n);
    }

    private int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}
