package threadingConsole;

import java.io.IOException;

public class ThreadingConsoleApp {

    public static void main(String[] args) {
        DateTimePrinterBackgroundWorker backgroundWorker = new DateTimePrinterBackgroundWorker();

        Thread th = new Thread(backgroundWorker);
        th.start();
        //backgroundWorker.run(); ACHTUNG: Startet keinen Thread
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            // Warten auf ein Zeichen
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Zeichen eingelesen
        backgroundWorker.setShouldRun(false);
        try {
            th.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
