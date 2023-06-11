package fibonacci;

import java.util.concurrent.CountDownLatch;

/**
 * La classe RecursiveFibonacci représente une version récursive du calcul de la suite de Fibonacci.
 * Elle étend la classe abstraite AbstractFibonacci.
 */
public class RecursiveFibonacci extends AbstractFibonacci {

    /**
     * Constructeur de la classe RecursiveFibonacci.
     *
     * @param n       l'indice n-ième de la suite de Fibonacci à calculer
     * @param synchro un compte à rebours utilisé pour synchroniser les threads
     */
    public RecursiveFibonacci(int n, CountDownLatch synchro) {
        super(n, synchro);
    }

    /**
     * Méthode qui exécute le calcul de la suite de Fibonacci de manière récursive.
     */
    @Override
    public void run() {
        try {
            synchro.await();  // On attend que tous les threads soient prêts
            long start = System.nanoTime(); // Temps avant l'exécution
            this.display = fib(n);
            long end = System.nanoTime(); // Temps après l'exécution

            resultTime = (end - start); //TimeFormatter.formatExecutionTime
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode qui calcule la suite de Fibonacci de manière récursive.
     *
     * @param n l'indice n-ième de la suite de Fibonacci
     * @return un tableau contenant la suite de Fibonacci calculée
     */
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

    /**
     * Méthode auxiliaire pour calculer la suite de Fibonacci en utilisant la mémoïsation.
     *
     * @param n    l'indice n-ième de la suite de Fibonacci
     * @param memo un tableau utilisé pour stocker les valeurs déjà calculées
     * @return la valeur de F(n)
     */
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
