package utils;

import fibonacci.IterativeFibonacci;
import fibonacci.RecursiveFibonacci;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * La classe FibonacciRunner permet d'exécuter les calculs de la suite de Fibonacci de manière concurrente.
 * Elle envoie ensuite les résultats d'exécution à la classe de formattage
 */
public class FibonacciRunner {
    /**
     * Exécute les calculs de la suite de Fibonacci.
     *
     * @param n l'indice n-ième de la suite de Fibonacci à calculer
     */
    public void run(int n) {
        // Préparation des ressources
        CountDownLatch synchro = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Préparation des threads:
        IterativeFibonacci iterativeFibonacci = new IterativeFibonacci(n, synchro);
        RecursiveFibonacci recursiveFibonacci = new RecursiveFibonacci(n, synchro);
        executor.execute(iterativeFibonacci);    // On met en place les threads
        executor.execute(recursiveFibonacci);

        synchro.countDown();  // 1
        synchro.countDown();  // 2
        synchro.countDown();  // 3
        // GO!    <- Démarrage de tous les threads en même temps

        executor.shutdown();
        try {
            // On attend que les 2 aient fini
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // On récupère les résultats d'exécution
        long fibResult = iterativeFibonacci.getResultTime();
        long fibRecResult = recursiveFibonacci.getResultTime();
        long[] fibDisplay = iterativeFibonacci.getDisplay();
        long[] fibRecDisplay = recursiveFibonacci.getDisplay();

        // Formattage de la sortie en console
        TimeFormatter formattage = new TimeFormatter();
        formattage.printFormatted(fibDisplay, fibResult, fibRecDisplay, fibRecResult);
    }
}
