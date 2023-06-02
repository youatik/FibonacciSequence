public class FibonacciRecursive implements FibonacciInterface {

    /**
     * Calcule le nième nombre de Fibonacci de manière récursive.
     *
     * @param n La position du nombre de Fibonacci à calculer.
     * @return Le nième nombre de Fibonacci.
     */
    @Override
    public int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n);
    }

    private int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}
