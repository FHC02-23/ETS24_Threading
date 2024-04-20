package threading05a;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {

    public static int Counter = 0;
    public static String key = "key";

    @Override
    public void run() {
        for (int i = 0; i< 1_000_000; i++) {
            increase();
        }
    }

    private void increase() {
        synchronized (key) {
            Counter++; // kritischen Code
        }
    }
}
