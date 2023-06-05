package execution;

import fibonacci.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FibonacciExecutor {
    private CompositeFibonacci compositeAlgorithm;
    private List<ExecutionResult> executionResults;

    public FibonacciExecutor(CompositeFibonacci compositeAlgorithm) {
        this.compositeAlgorithm = compositeAlgorithm;
        this.executionResults = new ArrayList<>();
    }

    public List<List<Long>> execute(int n) {
        List<List<Long>> results = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(compositeAlgorithm.getAlgorithms().size());
        List<Future<ExecutionResult>> futures = new ArrayList<>();

        for (Fibonacci algorithm : compositeAlgorithm.getAlgorithms()) {
            Callable<ExecutionResult> callable = () -> {
                long startTime = System.nanoTime();
                List<Long> sequence = algorithm.getFibonacciSequence(n);
                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;

                ExecutionResult result = new ExecutionResult(sequence, executionTime);
                return result;
            };
            Future<ExecutionResult> future = executorService.submit(callable);
            futures.add(future);
        }

        for (Future<ExecutionResult> future : futures) {
            try {
                ExecutionResult result = future.get();
                List<Long> sequence = result.getSequence();
                results.add(sequence);
                executionResults.add(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();

        return results;
    }

    public List<ExecutionResult> getExecutionResults() {
        return executionResults;
    }
}
