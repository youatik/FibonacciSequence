package Tim;


import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//OverFlow à partir du 93e index
public class Main {
    public static void main(String[] args) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez the n-ième index voulu de la suite de Fibonacci:");
        int n = scanner.nextInt();

        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Fibonacci fib = new Fibonacci(n, latch);
        RecursiveFibonacci fibRec = new RecursiveFibonacci(n, latch);

        executor.execute(fib);    //On met en place les threads
        executor.execute(fibRec);

        latch.countDown();  // 1
        latch.countDown();  // 2
        latch.countDown();  // 3
                            // GO!    <- Demarrage de tous les threads en même temps
        executor.shutdown();
    }
}
