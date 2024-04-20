package threading04;

public class Counter implements Runnable {

    public static int Counter = 0;

    //public boolean shouldRun = true;

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            increase();
            System.out.println(Counter);

            if (Thread.currentThread().isInterrupted())
                break;

            /*if (shouldRun == false)
                break;*/
        }
    }

    //synchronized (this)
    private void increase() {

        Counter = Counter + 1;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
