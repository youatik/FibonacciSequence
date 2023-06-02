import java.util.Scanner;

/**
 * Classe principale contenant la méthode main.
 */
public class Main {
    /**
     * Point d'entrée du programme.
     *
     * @param args Les arguments de ligne de commande.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la valeur de n : ");
        int n = scanner.nextInt();
        //scanner.close();

        System.out.print("Choisissez la version de Fibonacci (1 pour itérative, 2 pour récursive) : ");
        int choix = scanner.nextInt();

        int resultat;
        if (choix == 1) {
            Fibonacci fibonacci = new Fibonacci();
            resultat = fibonacci.fibonacci(n);
        } else if (choix == 2) {
            FibonacciRecursive fibonacciRecursive = new FibonacciRecursive();
            resultat = fibonacciRecursive.fibonacci(n);
        } else {
            System.out.println("Choix invalide. Veuillez choisir 1 ou 2.");
            return;
        }

        System.out.println("Le " + n + "ème nombre de Fibonacci est : " + resultat);
    }
}
