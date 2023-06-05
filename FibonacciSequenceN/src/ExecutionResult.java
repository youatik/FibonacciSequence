import java.util.List;

public class ExecutionResult {
    private List<Long> sequence;
    private long executionTime;

    public ExecutionResult(List<Long> sequence, long executionTime) {
        this.sequence = sequence;
        this.executionTime = executionTime;
    }

    public List<Long> getSequence() {
        return sequence;
    }

    public long getExecutionTime() {
        return executionTime;
    }
}
