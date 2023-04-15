package threading05;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {

    public static int Counter = 0;

    @Override
    public void run() {
        for (int i = 0; i< 1_000_000; i++) {
            increase();
        }
    }

    //private static Lock lock = new ReentrantLock();
    private void increase() {
        Counter++;
    }
}
