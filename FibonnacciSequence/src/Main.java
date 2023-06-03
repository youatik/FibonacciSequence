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
        boolean exit = false;

        while (!exit) {
            System.out.print("Entrez la valeur de n (ou -1 pour quitter) : ");
            int n = scanner.nextInt();
            if (n == -1) {
                exit = true;
                continue;
            }

            int resultat = new FibonacciTimingDecorator(new Fibonacci()).fibonacci(n);
            int resultatRecursive = new FibonacciTimingDecorator(new FibonacciRecursive()).fibonacci(n);

            System.out.println("Le " + n + "ème nombre de Fibonacci est : " + resultat);
            System.out.println("Le " + n + "ème nombre de Fibonacci est : " + resultatRecursive);

        }

        System.out.println("Programme terminé.");
    }
}