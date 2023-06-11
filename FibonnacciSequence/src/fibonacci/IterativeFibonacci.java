package fibonacci;

import java.util.concurrent.CountDownLatch;

/**
 * Implémentation de la suite de fibonacci Itérative
 */

public class IterativeFibonacci extends AbstractFibonacci {

    public IterativeFibonacci(int n, CountDownLatch synchro) {
        super(n, synchro);
    }

    @Override
    public void run() {
        try {
            synchro.await();  // On attend que tous les threads soient prêts
            long start = System.nanoTime(); //Temps avant l'execution
            this.display = calculateFibonacciSequence(n);
            long end = System.nanoTime(); //Temps après l'execution
            this.resultTime = (end - start);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

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
