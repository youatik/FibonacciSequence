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

            System.out.println("Le " + n + "ème nombre de Fibonacci est : " + new FibonacciTimingDecorator(new Fibonacci()).fibonacci(n));
            System.out.println("Le " + n + "ème nombre de Fibonacci Récursif est : " + new FibonacciTimingDecorator(new FibonacciRecursive()).fibonacci(n));
        }


        System.out.println("Programme terminé.");
    }
}
