package fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import timeFormatting.TimeFormatter;

public class FibonacciComposite implements FibonacciInterface {
    private List<FibonacciInterface> fibonacciObjects;

    public FibonacciComposite() {
        fibonacciObjects = new ArrayList<>();
    }

    public void addFibonacciObject(FibonacciInterface fibonacciObject) {
        fibonacciObjects.add(fibonacciObject);
    }

    @Override
    public long fibonacci(int n) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(fibonacciObjects.size());
        List<Future<Result>> results = new ArrayList<>();

        for (FibonacciInterface fibonacciObject : fibonacciObjects) {
            Callable<Result> task = () -> {
                long startTime = System.nanoTime();
                long result = fibonacciObject.fibonacci(n);
                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;
                return new Result(result, executionTime, fibonacciObject);
            };
            Future<Result> result = executorService.submit(task);
            results.add(result);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long firstResult = results.get(0).get().getResult();
        for (Future<Result> result : results) {
            Result fibonacciResult = result.get();
            if (fibonacciResult.getResult() != firstResult) {
                return -1; // Results are not equal, return -1
            }
            TimeFormatter timeFormatter = new TimeFormatter();
            String formattedTime = timeFormatter.formatExecutionTime(fibonacciResult.getExecutionTime());
            System.out.println("Execution time for " + fibonacciResult.getFibonacciObject().getClass().getSimpleName() + " object: " + formattedTime);
        }

        return firstResult; // Results are equal, return the result
    }

    @Override
    public List<Long> getFibonacciSequence() {
        if (fibonacciObjects.isEmpty()) {
            return new ArrayList<>();
        }
        return fibonacciObjects.get(0).getFibonacciSequence();
    }

    private static class Result {
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
    public void clearFibonacciObjects() {
        fibonacciObjects.clear();
    }
}
