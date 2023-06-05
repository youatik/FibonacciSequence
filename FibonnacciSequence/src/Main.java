import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import fibonacci.*;
import result.Result;
import timeFormatting.TimeFormatter;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //TimeFormatter timeFormatter = new TimeFormatter();
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        while (n != -1) {
            System.out.print("Enter the value of n (-1 to exit): ");
            n = scanner.nextInt();

            if (n == -1) {
                break;
            }

            FibonacciComposite fibonacciComposite = new FibonacciComposite();
            initializeFibonacciAlgorithms(fibonacciComposite);
            fibonacciComposite.fibonacci(n);
            List<Result> resultObjects = fibonacciComposite.getResultObjects();

            printExecutionTimes(resultObjects);
            printFibonacciSequences(resultObjects);
            printFastestObject(resultObjects);
        }
    }

    private static void initializeFibonacciAlgorithms(FibonacciComposite fibonacciComposite) {
        FibonacciInterface fibonacci = new Fibonacci();
        FibonacciInterface fibonacciRecursive = new FibonacciRecursive();
        fibonacciComposite.addFibonacciObject(fibonacci);
        fibonacciComposite.addFibonacciObject(fibonacciRecursive);
    }

    private static void printExecutionTimes(List<Result> resultObjects) {
        TimeFormatter timeFormatter = new TimeFormatter();

        System.out.println("Execution Times:");
        for (Result resultObject : resultObjects) {
            String fibonacciObjectName = resultObject.getFibonacciObject().getClass().getSimpleName();
            String executionTime = timeFormatter.formatExecutionTime(resultObject.getExecutionTime());
            System.out.println("Fibonacci Object: " + fibonacciObjectName + ", Execution Time: " + executionTime);
        }
    }

    private static void printFibonacciSequences(List<Result> resultObjects) {
        System.out.println("Fibonacci Sequences:");
        for (Result resultObject : resultObjects) {
            String fibonacciObjectName = resultObject.getFibonacciObject().getClass().getSimpleName();
            List<Long> fibonacciSequence = resultObject.getFibonacciObject().getFibonacciSequence();
            System.out.println("Fibonacci Object: " + fibonacciObjectName + ", Fibonacci Sequence: " + fibonacciSequence);
        }
    }

    private static void printFastestObject(List<Result> resultObjects) {
        Result fastestResult = Collections.min(resultObjects, Comparator.comparingLong(Result::getExecutionTime));
        String fastestObjectName = fastestResult.getFibonacciObject().getClass().getSimpleName();
        System.out.println("The fastest object is: " + fastestObjectName);
    }
}
