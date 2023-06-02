public class FibonacciTimingDecorator implements FibonacciInterface {
    private final FibonacciInterface fibonacciMethod;

    public FibonacciTimingDecorator(FibonacciInterface fibonacciMethod) {
        this.fibonacciMethod = fibonacciMethod;
    }

    @Override
    public int fibonacci(int n) {
        long startTime = System.nanoTime();
        int result = fibonacciMethod.fibonacci(n);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " nanoseconds");
        return result;
    }
}

