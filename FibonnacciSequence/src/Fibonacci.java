/**
 * Cette classe fournit une méthode pour calculer le nième nombre de Fibonacci.
 */
public class Fibonacci {

    /**
     * Calcule le nième nombre de Fibonacci.
     *
     * @param n La position du nombre de Fibonacci à calculer.
     * @return Le nième nombre de Fibonacci.
     */
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
