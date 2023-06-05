public class TimeFormatter {
    public static String formatExecutionTime(long executionTime) {
        if (executionTime >= 1_000_000_000) {
            return formatTime(executionTime, 1_000_000_000, "s");
        } else if (executionTime >= 1_000_000) {
            return formatTime(executionTime, 1_000_000, "ms");
        } else {
            return formatTime(executionTime, 1_000, "ns");
        }
    }

    private static String formatTime(long time, long divisor, String unit) {
        double formattedTime = (double) time / divisor;
        return String.format("%.2f", formattedTime) + unit;
    }
}
