package fibonacci;

import java.util.concurrent.CountDownLatch;

// Cette classe est une classe abstraite représentant une implémentation de base du calcul de la suite de Fibonacci.
public abstract class AbstractFibonacci implements Runnable{
    // Le n-ième nombre dans la suite de Fibonacci à calculer.
    protected final int n;
    // Objet CountDownLatch utilisé pour la synchronisation dans un contexte multithread.
    protected final CountDownLatch synchro;

    // Le temps de calcul du n-ième nombre de Fibonacci.
    protected long resultTime;
    // Le tableau qui contiendra les nombres de la suite de Fibonacci.
    protected long[] display;

    // Le constructeur qui initialise le n-ième nombre à calculer et l'objet de synchronisation.
    public AbstractFibonacci(int n, CountDownLatch synchro) {
        this.n = n;
        this.synchro = synchro;
    }

    // Cette méthode doit être implémentée dans une sous-classe.
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
    protected abstract long[] fib(int n);
}
