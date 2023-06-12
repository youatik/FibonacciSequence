import utils.FibonacciRunner;

import java.util.Scanner;



//OverFlow à partir du 93e index
import java.util.InputMismatchException;

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

                        switch (option) {
                            case 1:
                                System.out.println("Entrez l'indice n-ième voulu de la suite de Fibonacci (0 - 7500): ");
                                int n = 0;
                                try {
                                    // Récupération de l'indice de la suite de IterativeFibonacci
                                    n = scanner.nextInt();
                                    if (n < 0) {
                                        System.out.println("Veuillez entrer un nombre entier positif.");
                                        continue;
                                    } else if (n > 7500) {
                                        System.out.println("Veuillez entrer un nombre inférieur ou égal à 7500");
                                        continue;
                                    }
                                } catch (InputMismatchException ime) {
                                    System.out.println("Veuillez entrer un nombre entier valide.");
                                    scanner.next();
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