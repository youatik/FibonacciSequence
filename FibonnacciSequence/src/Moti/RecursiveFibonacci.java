package Moti;

import java.util.concurrent.CountDownLatch;

public class RecursiveFibonacci implements Runnable {
    private final int n;
    private final CountDownLatch synchro;  //Objet de synchronisation

    public RecursiveFibonacci(int n, CountDownLatch synchro) {
        this.n = n;
        this.synchro = synchro; //Objet dédié à la synchronisation des threads
    }

    @Override
    public void run() {
        try {
            synchro.await();  // On attend que tous les threads soient prêts
            long start = System.nanoTime(); //Temps avant l'execution
            long fib = fib(n);
            long end = System.nanoTime(); //Temps après l'execution
            System.out.println("Fibonacci Récursive,\nArgument No " + n + " = " + fib + ",\nTemps d'exécution: " + (end - start) + " nanosecondes");
            System.out.println("===============================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //Point d'entrée de l'algorithme  Complexité Temporelle : O(n) ;  Complexité Spatiale : O(n);
    public long fib(int n) {
        long[] memo = new long[n+1]; //On initialise un tableau afin de garder en mémoire les nombres déja calculés
        return fib(n, memo); //Appelle la fonction qui effectuera les calculs
    }


    //Fonction auxiliaire
    private long fib(int n, long[] memo) { //Prend l'index et le tableau en entrée
        if (n <= 1) { //Cas de base
            return n;
        }
        //Memoïsation: Avant de calculer fib(n), on verifie si on l'a déja calculé et gardé en mémoire dans le tableau (Tableau non initialisé == 0)
        else if (memo[n] == 0) {   // Si fib(n) n'a pas été calculé auparavant, nous le calculons maintenant en appelant récursivement fib sur n-1 et n-2.
            memo[n] = fib(n-1, memo) + fib(n-2, memo);  // Nous stockons ensuite cette valeur calculée dans memo[n] afin de ne pas avoir à la calculer à nouveau plus tard.
        }
        // À ce stade, memo[n] stocke le n-ième nombre de Fibonacci. Nous le renvoyons.
        return memo[n];                                           // OU Si ce n'est pas zéro (la valeur par défaut), cela signifie que fib(n) a été calculé auparavant, et nous pouvons le renvoyer directement.

        //On va préférer cette méthode à une méthode Récursive simple car cette derniere calcule plusieur fois la meme valeur.
    }
}
