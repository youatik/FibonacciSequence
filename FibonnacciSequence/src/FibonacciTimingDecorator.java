public class FibonacciTimingDecorator implements FibonacciInterface {
    private final FibonacciInterface fibonacciMethod;
    private final String objectName;

    public FibonacciTimingDecorator(FibonacciInterface fibonacciMethod) {
        this.fibonacciMethod = fibonacciMethod;
        this.objectName = fibonacciMethod.getClass().getSimpleName();
    }

    @Override
    public int fibonacci(int n) {
        long startTime = System.nanoTime();
        int result = fibonacciMethod.fibonacci(n);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        TimeFormatter timeFormatter = new TimeFormatter();
        String formattedTime = timeFormatter.formatExecutionTime(executionTime);

        System.out.println("Execution time for " + objectName + ": " + formattedTime);
        return result;
    }
}

