package Moti;

import java.util.concurrent.CountDownLatch;

public class Fibonacci implements Runnable {
    private final int n;
    private final CountDownLatch synchro;

    public Fibonacci(int n, CountDownLatch synchro) {
        this.n = n;
        this.synchro = synchro;  //Objet de synchronisation
    }

    @Override
    public void run() {
        try {
            synchro.await();  // On attend que tous les threads soient prêts
            long start = System.nanoTime(); //Temps avant l'execution
            long fib = fib(n);
            long end = System.nanoTime(); //Temps après l'execution
            System.out.println("Fibonacci Itérative,\nArgument No " + n + " = " + fib + ",\nTemps d'exécution: " + (end - start) + " nanosecondes");
            System.out.println("===============================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Complexité Temporelle : O(n); Complexité Spatiale: O(1)
    private long fib(int n) {
        if (n <= 1) { //Cas de base
            return n;
        }
        long fib = 1;
        long prevFib = 1;

        for (int i = 2; i < n; i++) {
            long temp = fib;  //On garde la valeur dans temp
            fib += prevFib;  //On additionne les deux nombre
            prevFib = temp;  //On assigne la valeur précédente à 'prevFib'
        }
        return fib;
    }
}
