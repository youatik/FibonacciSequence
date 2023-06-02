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

        FibonacciInterface fibonacciMethod;
        if (choix == 1) {
            fibonacciMethod = new Fibonacci();
        } else if (choix == 2) {
            fibonacciMethod = new FibonacciRecursive();
        } else {
            System.out.println("Choix invalide. Veuillez choisir 1 ou 2.");
            return;
        }

        FibonacciInterface timedFibonacci = new FibonacciTimingDecorator(fibonacciMethod);
        int resultat = timedFibonacci.fibonacci(n);

        System.out.println("Le " + n + "ème nombre de Fibonacci est : " + resultat);
    }
}

