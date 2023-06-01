/**
 * Cette classe fournit des méthodes récursives pour calculer le nième nombre de Fibonacci.
 */
public class FibonacciRecursive {

    /**
     * Calcule le nième nombre de Fibonacci de manière récursive.
     *
     * @param n La position du nombre de Fibonacci à calculer.
     * @return Le nième nombre de Fibonacci.
     */
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n);
    }

    /**
     * Calcule le nième nombre de Fibonacci de manière récursive.
     *
     * @param n La position du nombre de Fibonacci à calculer.
     * @return Le nième nombre de Fibonacci.
     */
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}
