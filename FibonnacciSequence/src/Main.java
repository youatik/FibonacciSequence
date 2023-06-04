import java.util.Scanner;
import fibonacci.*;
import timing.FibonacciTimingDecorator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Entrez la valeur de n (ou -1 pour quitter) : ");
            int n = scanner.nextInt();
            if (n == -1) {
                break;
            }

            long resultat = new FibonacciTimingDecorator(new Fibonacci()).fibonacci(n);
            long resultatRecursive = new FibonacciTimingDecorator(new FibonacciRecursive()).fibonacci(n);

            System.out.println("Le " + n + "ème nombre de Fibonacci est : " + resultat);
            System.out.println("Le " + n + "ème nombre de Fibonacci Récursif est : " + resultatRecursive);
        }


        System.out.println("Programme terminé.");
    }
}
