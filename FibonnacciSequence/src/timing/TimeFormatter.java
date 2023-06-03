package timing;

public class TimeFormatter {
    public String formatExecutionTime(long executionTime) {
        if (executionTime < 1_000) {
            return executionTime + " nanoseconds";
        } else if (executionTime < 1_000_000) {
            return (executionTime / 1_000) + " microseconds";
        } else if (executionTime < 1_000_000_000) {
            return (executionTime / 1_000_000) + " milliseconds";
        } else {
            return (executionTime / 1_000_000_000) + " seconds";
        }
    }
}