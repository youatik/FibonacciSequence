public class FibonacciTimingDecorator implements FibonacciInterface {
    private final FibonacciInterface fibonacciMethod;

    public FibonacciTimingDecorator(FibonacciInterface fibonacciMethod) {
        this.fibonacciMethod = fibonacciMethod;
    }

    @Override
    public int fibonacci(int n) {
        long startTime = System.currentTimeMillis();
        int result = fibonacciMethod.fibonacci(n);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " milliseconds");
        return result;
    }
}
