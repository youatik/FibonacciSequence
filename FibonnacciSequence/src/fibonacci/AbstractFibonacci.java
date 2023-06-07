package fibonacci;

import java.util.concurrent.CountDownLatch;

public abstract class AbstractFibonacci implements Runnable{
    protected final int n;
    protected final CountDownLatch synchro;

    protected long resultTime;
    protected long[] display;

    public AbstractFibonacci(int n, CountDownLatch synchro) {
        this.n = n;
        this.synchro = synchro;
    }
    public abstract void run();

    public long getResultTime() {
        return resultTime;
    }

    public long[] getDisplay() {
        return display;
    }

    public void setDisplay(long[] display) {
        this.display = display;
    }

    protected long[] initializeSequence(int n) {
        return new long[n + 1];
    }

    protected abstract long[] fib(int n);
}
