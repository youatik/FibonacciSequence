package fibonacci;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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

        for (FibonacciInterface fibonacciObject : fibonacciObjects)
        {
            Callable<Result> task = () ->
            {
                long startTime = System.nanoTime();
                long result = fibonacciObject.fibonacci(n);
                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;
                return new Result(result, executionTime);
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
            System.out.println("Execution time for Fibonacci object: " + fibonacciResult.getExecutionTime() + " nanoseconds");
        }

        return firstResult; // Results are equal, return the result
    }

    private static class Result
    {
        private final long result;
        private final long executionTime;

        public Result(long result, long executionTime)
        {
            this.result = result;
            this.executionTime = executionTime;
        }

        public long getResult()
        {
            return result;
        }

        public long getExecutionTime()
        {
            return executionTime;
        }
    }
}

