package execution;

import java.util.List;

public class ExecutionResult {
    private List<Long> sequence; // Séquence de Fibonacci calculée
    private long executionTime; // Temps d'exécution en nanosecondes

    public ExecutionResult(List<Long> sequence, long executionTime) {
        this.sequence = sequence; // Initialise la variable qui contient la séquence de Fibonacci
        this.executionTime = executionTime; // Initialise la variable qui contient le temps d'exécution
    }

    public List<Long> getSequence() {
        return sequence; // Renvoie la séquence de Fibonacci calculée
    }

    public long getExecutionTime() {
        return executionTime; // Renvoie le temps d'exécution en nanosecondes
    }
}
