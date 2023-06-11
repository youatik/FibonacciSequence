package fibonacci;

import java.util.concurrent.CountDownLatch;

// Cette classe est une classe abstraite représentant une implémentation de base de la suite de Fibonacci.
public abstract class AbstractFibonacci implements Runnable{

    // Le n-ième nombre dans la suite de Fibonacci à calculer.
    protected final int n;

    // Objet CountDownLatch utilisé pour la synchronisation dans un contexte multithread.
    protected final CountDownLatch synchro;

    protected long resultTime;

    protected long[] display;

    public AbstractFibonacci(int n, CountDownLatch synchro) {
        this.n = n;
        this.synchro = synchro;
    }

    public abstract void run();

    // Cette méthode retourne le temps de calcul du n-ième nombre de Fibonacci.
    public long getResultTime() {
        return resultTime;
    }

    // Cette méthode retourne le tableau contenant les nombres de la suite de Fibonacci.
    public long[] getDisplay() {
        return display;
    }

    // Cette méthode doit être implémentée dans une sous-classe pour calculer la suite de Fibonacci.
    protected abstract long[] calculateFibonacciSequence(int n);
}
