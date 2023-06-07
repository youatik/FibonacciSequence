package fibonacci;

import java.util.concurrent.CountDownLatch;

public class RecursiveFibonacci extends AbstractFibonacci {
    public RecursiveFibonacci(int n, CountDownLatch synchro) {
        super(n, synchro);
    }
    @Override
    public void run() {
        try {
            synchro.await();  // On attend que tous les threads soient prêts
            long start = System.nanoTime(); //Temps avant l'execution
            this.display = fib(n);
            long end = System.nanoTime(); //Temps après l'execution

            resultTime = (end - start); //TimeFormatter.formatExecutionTime
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

// Fonction principale pour obtenir la séquence de Fibonacci jusqu'à n.
    @Override
    public long[] fib(int n) {
        // Initialisation du tableau de la séquence.
        long[] sequence = new long[n + 1];

        // Initialisation des cas de base de la séquence de Fibonacci.
        if (n >= 0) {
            sequence[0] = 0; // F(0)
        }
        if (n >= 1) {
            sequence[1] = 1; // F(1)
        }

        // Calcul du reste de la séquence.
        fib(n, sequence);

        // Renvoi de la séquence complète.
        return sequence;
    }

    // Fonction auxiliaire pour calculer la séquence de Fibonacci en utilisant la mémoïsation.
    private long fib(int n, long[] memo) {
        // Cas de base : si n <= 1, la valeur est déjà en mémoire.
        if (n <= 1) {
            return memo[n];
        }

        // Si la valeur n'est pas encore calculée, on le fait maintenant.
        else if (memo[n] == 0) {
            // Calcul de F(n) et mise en mémoire pour usage ultérieur.
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        }

        // Renvoi de F(n).
        return memo[n];
    }
}
