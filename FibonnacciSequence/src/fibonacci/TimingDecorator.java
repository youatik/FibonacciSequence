package fibonacci;

public class TimingDecorator implements FibonacciInterface {
    private FibonacciInterface fibonacciObject;
    private String objectName;

    public TimingDecorator(FibonacciInterface fibonacciObject, String objectName) {
        this.fibonacciObject = fibonacciObject;
        this.objectName = objectName;
    }

    @Override
    public long fibonacci(int n) {
        long startTime = System.nanoTime();
        long result = fibonacciObject.fibonacci(n);
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;
        System.out.println("Execution time for " + objectName + ": " + executionTime + " nanoseconds");

        return result;
    }
}
