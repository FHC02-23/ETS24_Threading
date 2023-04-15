package threading02;

public class ConsolePrinter implements Runnable {


    private String identifier;

    private boolean pleaseStop;

    public ConsolePrinter(String identifier) {
        this.identifier = identifier;
        pleaseStop = false;
    }

    public void stopRunning() {
        pleaseStop = true;
    }

    public void logic() {
        for (int i = 0; i < 1_000_000; i++) {
            System.out.println(i + ": [identifier: " + identifier + ']');

            if (pleaseStop == true)
                break;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

                e.printStackTrace();
                break;
            }
        }
    }

    @Override
    public void run() {
        logic();
    }
}
