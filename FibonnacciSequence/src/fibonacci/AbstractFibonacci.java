package fibonacci;

import java.util.concurrent.CountDownLatch;

/**
 * La classe abstraite AbstractFibonacci définit les fonctionnalités communes pour les versions itérative et récursive du calcul de la suite de Fibonacci.
 */
public abstract class AbstractFibonacci implements Runnable {

    protected final int n;

    // Objet CountDownLatch utilisé pour la synchronisation dans un contexte multithread.
    protected final CountDownLatch synchro;

    protected long resultTime;

    protected long[] display;

    /**
     * Constructeur de la classe AbstractFibonacci.
     *
     * @param n        l'indice n-ième de la suite de Fibonacci à calculer
     * @param synchro  un compte à rebours utilisé pour synchroniser les threads
     */
    public AbstractFibonacci(int n, CountDownLatch synchro) {
        this.n = n;
        this.synchro = synchro;
    }


    /**
     * Méthode abstraite qui doit être implémentée par les sous-classes pour effectuer le calcul de la suite de Fibonacci.
     */
    public abstract void run();

    /**
     * Récupère le temps d'exécution du calcul de la suite de Fibonacci.
     *
     * @return le temps d'exécution en nanosecondes
     */
    public long getResultTime() {
        return resultTime;
    }


    /**
     * Récupère les valeurs de la suite de Fibonacci calculées.
     *
     * @return un tableau contenant les valeurs de la suite de Fibonacci
     */

    public long[] getDisplay() {
        return display;
    }


    // Cette méthode doit être implémentée dans une sous-classe pour calculer la suite de Fibonacci.
    protected abstract long[] calculateFibonacciSequence(int n);

}
