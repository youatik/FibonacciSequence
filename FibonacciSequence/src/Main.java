import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.print("Enter the value of n (enter 0 to exit): ");
            int n = scanner.nextInt();

            Fibonacci fibonacciIterative = new FibonacciIterative();
            Fibonacci fibonacciRecursive = new FibonacciRecursive();

            CompositeFibonacci compositeFibonacci = new CompositeFibonacci();
            compositeFibonacci.addAlgorithm(fibonacciIterative);
            compositeFibonacci.addAlgorithm(fibonacciRecursive);

            FibonacciExecutor fibonacciExecutor = new FibonacciExecutor(compositeFibonacci);

            if (n == 0) {
                keepRunning = false;
                System.out.println("Exiting the program...");
            } else {
                List<List<Long>> results = fibonacciExecutor.execute(n);

                System.out.println("Iterative Sequence:");
                printFibonacciSequence(results.get(0));

                System.out.println("Recursive Sequence:");
                printFibonacciSequence(results.get(1));

                List<ExecutionResult> executionResults = fibonacciExecutor.getExecutionResults();
                for (int i = 0; i < executionResults.size(); i++) {
                    ExecutionResult result = executionResults.get(i);
                    Fibonacci algorithm = compositeFibonacci.getAlgorithms().get(i);
                    long executionTime = result.getExecutionTime();
                    String formattedTime = TimeFormatter.formatExecutionTime(executionTime);
                    System.out.println(algorithm.getClass().getSimpleName() + " execution time: " + formattedTime);
                }
            }
        }
    }

    private static void printFibonacciSequence(List<Long> sequence) {
        for (Long num : sequence) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
