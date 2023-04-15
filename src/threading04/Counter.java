package threading04;

public class Counter implements Runnable {

    public static int Counter = 0;

    public static String key = "";

    @Override
    public void run() {
        for (int i = 0; i< 1_000_000; i++) {
            increase();
        }
    }

    //synchronized (this)
    private void increase() {
        //some code

        // andere Threads warten
        synchronized (key) {
            Counter = Counter + 1;
        }

    }
}
