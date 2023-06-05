import java.util.ArrayList;
import java.util.List;

public class FibonacciIterative implements Fibonacci {
    @Override
    public List<Long> getFibonacciSequence(int n) {
        List<Long> result = new ArrayList<>();

        if (n >= 1) {
            result.add(0L);
        }
        if (n >= 2) {
            result.add(1L);
        }

        if (n >= 3) {
            long prev = 0;
            long curr = 1;
            for (int i = 3; i <= n; i++) {
                long next = prev + curr;
                result.add(next);
                prev = curr;
                curr = next;
            }
        }

        return result;
    }
}
