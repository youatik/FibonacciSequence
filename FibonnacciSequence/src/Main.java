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

            FibonacciInterface fibonacci = new Fibonacci();
            FibonacciInterface fibonacciRecursive = new FibonacciRecursive();

            FibonacciInterface fibonacciWithTiming = new FibonacciTimingDecorator(fibonacci);
            FibonacciInterface fibonacciRecursiveWithTiming = new FibonacciTimingDecorator(fibonacciRecursive);

            long resultat = fibonacciWithTiming.fibonacci(n);
            long resultatRecursive = fibonacciRecursiveWithTiming.fibonacci(n);

            System.out.println("Le " + n + "ème nombre de Fibonacci est : " + resultat);
            System.out.println("Le " + n + "ème nombre de Fibonacci Récursif est : " + resultatRecursive);
        }


        System.out.println("Programme terminé.");
    }
}
