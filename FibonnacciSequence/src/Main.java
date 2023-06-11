import utils.FibonacciRunner;
import utils.TimeFormatter;
import fibonacci.Fibonacci;
import fibonacci.RecursiveFibonacci;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Classe principale du programme Fibonacci.
 */
public class Main {
    /**
     * Méthode principale qui s'exécute lors du lancement du programme.
     *
     * @param args les arguments de ligne de commande (non utilisés dans ce programme)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do {
            // Affichage du menu
            System.out.println("\nMenu:");
            System.out.println("1. Exécutez Fibonacci.");
            System.out.println("2. Quitter.");
            System.out.print("Choisissez une option: ");

            try {
                // Récupération de l'option choisie par l'utilisateur
                option = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Veuillez entrer un nombre entier valide.");
                scanner.next();
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println("Entrez l'indice n-ième voulu de la suite de Fibonacci:");
                    int n;
                    try {
                        // Récupération de l'indice de la suite de Fibonacci
                        n = scanner.nextInt();
                        if (n < 0) {
                            System.out.println("Veuillez entrer un nombre entier positif.");
                            continue;
                        }
                    } catch (InputMismatchException ime) {
                        System.out.println("Veuillez entrer un nombre entier valide.");
                        scanner.next();
                        continue;
                    }

                    // Création et exécution du runner Fibonacci
                    FibonacciRunner gameEngine = new FibonacciRunner();
                    gameEngine.run(n);
                    break;
                case 2:
                    // Sortie du programme
                    System.out.println("Sortie du programme.");
                    break;
                default:
                    // Gestion des options invalides
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        } while (option != 2);

        // Fermeture du scanner après utilisation
        scanner.close();
    }
}
