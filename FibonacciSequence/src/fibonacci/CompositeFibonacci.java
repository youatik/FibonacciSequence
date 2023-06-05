package fibonacci;

import java.util.ArrayList;
import java.util.List;

public class CompositeFibonacci implements Fibonacci {
    private List<Fibonacci> algorithms;

    public CompositeFibonacci() {
        algorithms = new ArrayList<>();
    }

    public void addAlgorithm(Fibonacci algorithm) {
        algorithms.add(algorithm);
    }

    public List<Fibonacci> getAlgorithms() {
        return algorithms;
    }

    public List<List<Long>> getFibonacciSequences(int n) {
        List<List<Long>> sequences = new ArrayList<>();
        for (Fibonacci algorithm : algorithms) {
            sequences.add(algorithm.getFibonacciSequence(n));
        }
        return sequences;
    }

    @Override
    public List<Long> getFibonacciSequence(int n) {
        List<Long> result = new ArrayList<>();
        for (Fibonacci algorithm : algorithms) {
            result.addAll(algorithm.getFibonacciSequence(n));
        }
        return result;
    }
}
