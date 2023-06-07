package utils;

// La classe TimeFormatter est responsable de l'affichage formaté des résultats.
public  class TimeFormatter {

    // Cette méthode imprime les séquences de Fibonacci et les temps d'exécution pour les versions récursive et itérative.
    public void printFormatted(long[] display, long nanoSeconds, long[] displayRecursive, long nanoSecondsRec) {
        // Conversion du temps d'exécution en microsecondes et formatage pour affichage.
        String iterativeTime = String.format("%.2f", nanoSeconds / 1e3);
        String recursiveTime = String.format("%.2f", nanoSecondsRec / 1e3);

        // Affichage des résultats pour la version récursive.
        System.out.println("Fibonacci Récursive");
        System.out.println(recursiveTime + " microsecondes");
        printArray(displayRecursive);
        if(displayRecursive.length < 93) {
            printArray(displayRecursive);
        } else {
            System.out.println("StackOverflow, Données erronées");
        }
        System.out.println("=============================");

        // Affichage des résultats pour la version itérative.
        System.out.println("Fibonacci Itérative");
        System.out.println(iterativeTime + " microsecondes");
        if(display.length < 93) {
            printArray(display);
        } else {
            System.out.println("StackOverflow, Données erronées");
        }
        System.out.println("=============================");

        // Détermination et affichage de la méthode la plus rapide.
        String winner = (nanoSeconds < nanoSecondsRec) ? "Itérative" : "Recursive";
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
