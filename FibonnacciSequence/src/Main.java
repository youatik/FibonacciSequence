import utils.TimeFormatter;
import fibonacci.Fibonacci;
import fibonacci.RecursiveFibonacci;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


//OverFlow à partir du 93e index
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez the n-ième index voulu de la suite de Fibonacci:");
        int n = scanner.nextInt();

        //Préparation des ressources
        CountDownLatch synchro = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //Préparation des threads:
        Fibonacci fib = new Fibonacci(n, synchro);
        RecursiveFibonacci fibRec = new RecursiveFibonacci(n, synchro);
        executor.execute(fib);    //On met en place les threads
        executor.execute(fibRec);

        //
        synchro.countDown();  // 1
        synchro.countDown();  // 2
        synchro.countDown();  // 3
                            // GO!    <- Demarrage de tous les threads en même temps
        executor.shutdown();
        try {
            //On attend que les 2 aient fini
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //On récupère les résultats d'exécution
        long fibResult = fib.getResultTime();
        long fibRecResult = fibRec.getResultTime();
        long[] fibDisplay = fib.getDisplay();
        long[] fibRecDisplay = fibRec.getDisplay();

        //Formattage de la sortie en console
        TimeFormatter formattage = new TimeFormatter();
        formattage.printFormatted(fibDisplay, fibResult, fibRecDisplay, fibRecResult);
    }
}
