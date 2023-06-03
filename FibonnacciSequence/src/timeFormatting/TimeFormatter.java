package timeFormatting;

import java.text.DecimalFormat;

public class TimeFormatter {
    public String formatExecutionTime(long executionTime) {
        if (executionTime < 1_000) {
            return formatWithDecimal(executionTime, 2) + " nanoseconds";
        } else if (executionTime < 1_000_000) {
            return formatWithDecimal((double) executionTime / 1_000, 2) + " microseconds";
        } else if (executionTime < 1_000_000_000) {
            return formatWithDecimal((double) executionTime / 1_000_000, 2) + " milliseconds";
        } else {
            return formatWithDecimal((double) executionTime / 1_000_000_000, 2) + " seconds";
        }
    }

    private String formatWithDecimal(double value, int minFractionDigits) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        decimalFormat.setMinimumFractionDigits(minFractionDigits);
        decimalFormat.setMaximumFractionDigits(minFractionDigits);
        return decimalFormat.format(value);
    }
}
