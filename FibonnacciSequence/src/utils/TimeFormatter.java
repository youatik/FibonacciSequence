package utils;

/**
 * La classe TimeFormatter est responsable de l'affichage formaté des résultats, en prenant les tableau d'affichage
 *  ainsi que le temps d'exécution de chaque méthode.
  */

public  class TimeFormatter {

    private static final int maximumIndex = 93;

    // Cette méthode imprime les séquences de IterativeFibonacci et les temps d'exécution pour les versions récursive et itérative.
    public void printFormatted(long[] display, long executionTimeIterative, long[] displayRecursive, long executionTimeRecursive) {
        // Conversion du temps d'exécution en microsecondes et formatage pour affichage.
        String iterativeTime = String.format("%.2f", executionTimeIterative / 1e3);
        String recursiveTime = String.format("%.2f", executionTimeRecursive / 1e3);

        // Affichage des résultats pour la version récursive.
        System.out.println("Fibonacci Récursive");
        System.out.println("Temps d'exécution: " + recursiveTime + " microsecondes");
        if(displayRecursive.length < maximumIndex) {
            printArray(displayRecursive);
        } else {
            System.out.println("À partir du 93e index, on ne peut représenter les données");
        }
        System.out.println("=============================");

        // Affichage des résultats pour la version itérative.
        System.out.println("Fibonacci Itérative");
        System.out.println("Temps d'exécution: " + iterativeTime + " microsecondes");
        if(display.length < 93) {
            printArray(display);
        } else {
            System.out.println("À partir du 93e index, on ne peut représenter les données");
        }
        System.out.println("=============================");

        // Détermination et affichage de la méthode la plus rapide.
        String winner = (executionTimeIterative < executionTimeRecursive) ? "Itérative" : "Recursive";
        System.out.println("Gagnant : " + winner);
    }

    // Cette méthode imprime un tableau de longues valeurs à la console.
    private static void printArray(long[] array) {
        // Début de l'affichage du tableau.
        System.out.print("[");
        // Boucle sur chaque élément du tableau.
        for (int i = 0; i < array.length; i++) {
            // Affichage de l'élément actuel.
            System.out.print(array[i]);
            // Ajout d'une virgule après chaque élément sauf le dernier.
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        // Fin de l'affichage du tableau.
        System.out.println("]");
    }
}
