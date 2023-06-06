package fibonacci;

import java.util.ArrayList;
import java.util.List;

public class FibonacciRecursive implements Fibonacci {
    @Override
    public List<Long> getFibonacciSequence(int n) {
        List<Long> result = new ArrayList<>(); // Liste pour stocker la séquence de Fibonacci
        for (int i = 0; i < n; i++) {
            result.add(calculateFibonacci(i)); // Appelle la méthode récursive pour calculer chaque nombre de Fibonacci et l'ajoute à la liste
        }
        return result; // Renvoie la séquence de Fibonacci calculée
    }

    private long calculateFibonacci(int n) {
        if (n <= 1) {
            return n; // Cas de base : renvoie n si n est 0 ou 1
        }
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2); // Appel récursif pour calculer le nombre de Fibonacci en utilisant la relation F(n) = F(n-1) + F(n-2)
    }
}
