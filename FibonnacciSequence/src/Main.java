import utils.FibonacciRunner;

import java.util.Scanner;


//OverFlow à partir du 93e index
import java.util.InputMismatchException;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int option = 0;
            do {
                // Affichage du menu
                System.out.println("\nMenu:");
                System.out.println("1. Executer la Suite de Fibonacci.");
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
                        System.out.println("Entrez l'indice n-ième voulu de la suite de Fibonacci (0 - 7500): ");
                        int n;
                        try {
                            // Récupération de l'indice de la suite de IterativeFibonacci
                            n = scanner.nextInt();
                            if (n < 0) {
                                System.out.println("Veuillez entrer un nombre entier positif.");
                                continue;
                            }
                            else if (n > 7500) {
                                System.out.println("Veuillez entrer un nombre inférieur ou égal à 7500");
                                continue;
                            }
                        } catch (InputMismatchException ime) {
                            System.out.println("Veuillez entrer un nombre entier valide.");
                            scanner.next();
                            continue;
                        }

                        // Création et exécution du runner IterativeFibonacci
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


