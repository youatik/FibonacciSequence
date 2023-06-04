package fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import result.Result; // Import the Result class from the result package

public class FibonacciComposite implements FibonacciInterface {
    private List<FibonacciInterface> fibonacciObjects;
    private List<Result> resultObjects; // List to store Result objects

    public FibonacciComposite() {
        fibonacciObjects = new ArrayList<>();
        resultObjects = new ArrayList<>();
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
                Result resultObj = new Result(result, executionTime, fibonacciObject);
                resultObjects.add(resultObj); // Add Result object to the list
                return resultObj;
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

    public void clearFibonacciObjects() {
        fibonacciObjects.clear();
        resultObjects.clear(); // Clear the result objects list
    }

    public List<Result> getResultObjects() {
        return resultObjects; // Accessor method for the result objects list
    }
}
