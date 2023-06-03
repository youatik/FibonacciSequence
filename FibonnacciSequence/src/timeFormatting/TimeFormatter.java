package timeFormatting;


public class TimeFormatter {
    public String formatExecutionTime(long executionTime) {
        if (executionTime < 1_000) {
            return formatWithDecimal(executionTime) + " nanoseconds";
        } else if (executionTime < 1_000_000) {
            return formatWithDecimal((double) executionTime / 1_000) + " microseconds";
        } else if (executionTime < 1_000_000_000) {
            return formatWithDecimal((double) executionTime / 1_000_000) + " milliseconds";
        } else {
            return formatWithDecimal((double) executionTime / 1_000_000_000) + " seconds";
        }
    }

    private String formatWithDecimal(double value) {
        return String.format("%.2f", value);
    }

}
