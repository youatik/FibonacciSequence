package timeFormat;

public class TimeFormatter {
    public static String formatExecutionTime(long executionTime) {
        if (executionTime >= 1_000_000_000) {
            return formatTime(executionTime, 1_000_000_000, "s"); // Formate le temps d'exécution en secondes si supérieur ou égal à 1 milliard de nanosecondes
        } else if (executionTime >= 1_000_000) {
            return formatTime(executionTime, 1_000_000, "ms"); // Formate le temps d'exécution en millisecondes si supérieur ou égal à 1 million de nanosecondes
        } else {
            return formatTime(executionTime, 1_000, "ns"); // Formate le temps d'exécution en nanosecondes si inférieur à 1 million de nanosecondes
        }
    }

    private static String formatTime(long time, long divisor, String unit) {
        double formattedTime = (double) time / divisor;
        return String.format("%.2f", formattedTime) + unit; // Formate le temps en utilisant deux décimales et ajoute l'unité de mesure
    }
}

