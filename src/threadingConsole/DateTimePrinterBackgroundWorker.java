package threadingConsole;

import java.util.Date;

public class DateTimePrinterBackgroundWorker implements Runnable {

    private boolean shouldRun;

    public DateTimePrinterBackgroundWorker() {
        this.shouldRun = true;
    }

    public void setShouldRun(boolean shouldRun) {
        this.shouldRun = shouldRun;
    }

    public void worker() {

        while (shouldRun) {
            Date d = new Date();
            System.out.println(d);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { // erklärung noch ausständing
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        shouldRun = true;
        worker();
    }
}
