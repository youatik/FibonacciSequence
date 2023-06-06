import execution.*;
import fibonacci.*;
import timeFormat.TimeFormatter;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.print("Entrez la valeur de n (entrez 0 pour quitter) : "); // Demande à l'utilisateur d'entrer la valeur de n
            int n = scanner.nextInt();

            Fibonacci fibonacciIterative = new FibonacciIterative(); // Crée une instance de FibonacciIterative
            Fibonacci fibonacciRecursive = new FibonacciRecursive(); // Crée une instance de FibonacciRecursive

            CompositeFibonacci compositeFibonacci = new CompositeFibonacci(); // Crée une instance de CompositeFibonacci
            compositeFibonacci.addAlgorithm(fibonacciIterative); // Ajoute l'algorithme itératif à CompositeFibonacci
            compositeFibonacci.addAlgorithm(fibonacciRecursive); // Ajoute l'algorithme récursif à CompositeFibonacci

            FibonacciExecutor fibonacciExecutor = new FibonacciExecutor(compositeFibonacci); // Crée une instance de FibonacciExecutor

            if (n == 0) {
                keepRunning = false;
                System.out.println("Programme terminé..."); // Affiche un message de fin si l'utilisateur entre 0
            } else {
                List<List<Long>> results = fibonacciExecutor.execute(n); // Exécute les algorithmes de Fibonacci pour la valeur de n donnée

                System.out.println("Séquence itérative :"); // Affiche le titre de la séquence itérative
                printFibonacciSequence(results.get(0)); // Affiche la séquence itérative

                System.out.println("Séquence récursive :"); // Affiche le titre de la séquence récursive
                printFibonacciSequence(results.get(1)); // Affiche la séquence récursive

                List<ExecutionResult> executionResults = fibonacciExecutor.getExecutionResults(); // Obtient les résultats d'exécution
                for (int i = 0; i < executionResults.size(); i++) {
                    ExecutionResult result = executionResults.get(i);
                    Fibonacci algorithm = compositeFibonacci.getAlgorithms().get(i);
                    long executionTime = result.getExecutionTime();
                    String formattedTime = TimeFormatter.formatExecutionTime(executionTime);
                    System.out.println("Temps d'exécution de " + algorithm.getClass().getSimpleName() + " : " + formattedTime); // Affiche le temps d'exécution pour chaque algorithme
                }
            }
        }
    }

    private static void printFibonacciSequence(List<Long> sequence) {
        for (Long num : sequence) {
            System.out.print(num + " "); // Affiche chaque nombre de la séquence
        }
        System.out.println();
    }
}
