package result;

import fibonacci.FibonacciInterface;

public class Result {
    private final long result;
    private final long executionTime;
    private final FibonacciInterface fibonacciObject;

    public Result(long result, long executionTime, FibonacciInterface fibonacciObject) {
        this.result = result;
        this.executionTime = executionTime;
        this.fibonacciObject = fibonacciObject;
    }

    public long getResult() {
        return result;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public FibonacciInterface getFibonacciObject() {
        return fibonacciObject;
    }
}
