package fibonacci;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface FibonacciInterface {
    long fibonacci(int n) throws ExecutionException, InterruptedException;

    List<Long> getFibonacciSequence();

}

