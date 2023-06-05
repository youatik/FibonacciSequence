package timeFormatting;

public class TimeFormatter {
    public String formatExecutionTime(long executionTime) {
        String unit;
        double timeValue = executionTime;

        if (executionTime < 1_000) {
            unit = "nanoseconds";
        } else if (executionTime < 1_000_000) {
            unit = "microseconds";
            timeValue = executionTime / 1_000.0;
        } else if (executionTime < 1_000_000_000) {
            unit = "milliseconds";
            timeValue = executionTime / 1_000_000.0;
        } else {
            unit = "seconds";
            timeValue = executionTime / 1_000_000_000.0;
        }

        return String.format("%.2f %s", timeValue, unit);
    }
}

