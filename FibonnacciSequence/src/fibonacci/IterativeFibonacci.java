package fibonacci;

import java.util.concurrent.CountDownLatch;

/**
<<<<<<< HEAD:FibonnacciSequence/src/fibonacci/IterativeFibonacci.java
 * Implémentation de la suite de fibonacci Itérative
 */

public class IterativeFibonacci extends AbstractFibonacci {

    public IterativeFibonacci(int n, CountDownLatch synchro) {
        super(n, synchro);
    }

    /**
     * Méthode qui exécute le calcul de la suite de Fibonacci de manière itérative.
     */
    @Override
    public void run() {
        try {
            synchro.await();  // On attend que tous les threads soient prêts
            long start = System.nanoTime(); //Temps avant l'exécution
            this.display = calculateFibonacciSequence(n);
            long end = System.nanoTime(); //Temps après l'exécution

            this.resultTime = (end - start);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode qui calcule la suite de Fibonacci de manière itérative.
     *
     * @param n l'indice n-ième de la suite de Fibonacci
     * @return un tableau contenant la suite de Fibonacci calculée
     */
    @Override
    protected long[] calculateFibonacciSequence(int n) {
        // Initialisation du tableau de la séquence.
        long[] sequence = new long[n + 1];

        // Initialisation du cas de base F(1).
        if (n > 0) {
            sequence[1] = 1;
        }

        // Calcul des éléments restants de la séquence.
        for (int i = 2; i <= n; i++) {
            // Chaque élément est la somme des deux précédents.
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }

        // Renvoi de la séquence complète.
        return sequence;
    }
}
