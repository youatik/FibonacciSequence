package fibonacci;
import fibonacci.FibonacciInterface;
import java.util.HashMap;
import java.util.Map;

public class FibonacciComposite implements FibonacciInterface {
    private final Map<FibonacciInterface, Long> resultsMap;

    public FibonacciComposite() {
        resultsMap = new HashMap<>();
    }

    public void addFibonacciObject(FibonacciInterface fibonacciObject) {
        resultsMap.put(fibonacciObject, null);
    }

    public Map<FibonacciInterface, Long> getResultsMap() {
        return resultsMap;
    }

    @Override
    public long fibonacci(int n) {
        for (FibonacciInterface fibonacciObject : resultsMap.keySet()) {
            if (resultsMap.get(fibonacciObject) == null) {
                long result = fibonacciObject.fibonacci(n);
                resultsMap.put(fibonacciObject, result);
            }
        }
        return 0L; // Placeholder return statement, modify as needed
    }
}
