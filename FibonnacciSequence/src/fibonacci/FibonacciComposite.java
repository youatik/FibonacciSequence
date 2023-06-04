package fibonacci;

import java.util.ArrayList;
import java.util.List;

public class FibonacciComposite implements FibonacciInterface {
    private List<FibonacciInterface> fibonacciObjects;

    public FibonacciComposite() {
        fibonacciObjects = new ArrayList<>();
    }

    public void addFibonacciObject(FibonacciInterface fibonacciObject) {
        fibonacciObjects.add(fibonacciObject);
    }

    @Override
    public long fibonacci(int n) {
        long result = fibonacciObjects.get(0).fibonacci(n); // Get the result from the first Fibonacci object
        for (int i = 1; i < fibonacciObjects.size(); i++) {
            long currentResult = fibonacciObjects.get(i).fibonacci(n);
            if (currentResult != result) {
                return -1; // Results are not equal, return -1
            }
        }
        return result; // Results are equal, return the result
    }
}
