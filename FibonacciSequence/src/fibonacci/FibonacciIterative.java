package fibonacci;

import fibonacci.Fibonacci;

import java.util.ArrayList;
import java.util.List;

public class FibonacciIterative implements Fibonacci {
    @Override
    public List<Long> getFibonacciSequence(int n) {
        List<Long> result = new ArrayList<>(); // Liste pour stocker la séquence de Fibonacci

        if (n >= 1) {
            result.add(0L); // Ajoute le premier nombre de Fibonacci (0) à la liste
        }
        if (n >= 2) {
            result.add(1L); // Ajoute le deuxième nombre de Fibonacci (1) à la liste
        }

        if (n >= 3) {
            long prev = 0; // Nombre précédent dans la séquence
            long curr = 1; // Nombre courant dans la séquence
            for (int i = 3; i <= n; i++) {
                long next = prev + curr; // Calcule le prochain nombre de Fibonacci
                result.add(next); // Ajoute le prochain nombre à la liste
                prev = curr; // Met à jour le nombre précédent
                curr = next; // Met à jour le nombre courant
            }
        }

        return result; // Renvoie la séquence de Fibonacci calculée
    }
}
