package fibonacci;

import java.util.ArrayList;
import java.util.List;

public class CompositeFibonacci implements Fibonacci {
    private List<Fibonacci> algorithms; // Liste pour stocker les algorithmes de Fibonacci

    public CompositeFibonacci() {
        algorithms = new ArrayList<>(); // Initialise la liste des algorithmes
    }

    public void addAlgorithm(Fibonacci algorithm) {
        algorithms.add(algorithm); // Ajoute un algorithme à la liste
    }

    public List<Fibonacci> getAlgorithms() {
        return algorithms; // Renvoie la liste des algorithmes de Fibonacci
    }

    @Override
    public List<Long> getFibonacciSequence(int n) {
        List<Long> result = new ArrayList<>(); // Liste pour stocker la séquence de Fibonacci
        for (Fibonacci algorithm : algorithms) {
            result.addAll(algorithm.getFibonacciSequence(n)); // Appelle la méthode getFibonacciSequence pour chaque algorithme et ajoute les nombres de Fibonacci à la liste
        }
        return result; // Renvoie la séquence de Fibonacci combinée de tous les algorithmes
    }
}
