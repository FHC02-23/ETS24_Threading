package threading02;

public class ConsolePrinter implements Runnable {

    private String identifier;

    public ConsolePrinter(String identifier) {
        this.identifier = identifier;
        pleaseStop = false;
    }

    public boolean pleaseStop;

    public void logic() {
        for (int i = 0; i < 1_000; i++) {
            System.out.println(i + ": [identifier: " + identifier + ']');

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
