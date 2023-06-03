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
        String formattedTime = formatExecutionTime(executionTime);
        System.out.println("Execution time for " + objectName + ": " + formattedTime);
        return result;
    }

    private String formatExecutionTime(long executionTime) {
        if (executionTime < 1_000) {
            return executionTime + " nanoseconds";
        } else if (executionTime < 1_000_000) {
            return (executionTime / 1_000) + " microseconds";
        } else if (executionTime < 1_000_000_000) {
            return (executionTime / 1_000_000) + " milliseconds";
        } else {
            return (executionTime / 1_000_000_000) + " seconds";
        }
    }
}
