package threading01;

public class ConsolePrinter extends Thread {

    private String identifier;

    public ConsolePrinter(String identifier) {

        this.identifier = identifier;
    }

    @Override
    public void run() {
        logic();
    }

    private void logic() {
        for (int i = 0; i < 1_000_000; i++) {
            System.out.println(i + ": [identifier: " + identifier + ']');

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
