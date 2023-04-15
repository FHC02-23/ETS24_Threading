package threading02;

public class ConsolePrinterDemoApp {

    public static void main(String[] args) throws InterruptedException {


        ConsolePrinter cpA = new ConsolePrinter("A");
        ConsolePrinter cpB = new ConsolePrinter("B");

        Thread threadCpA = new Thread(cpA);
        Thread threadCpB = new Thread(cpB);

        threadCpA.start();
        threadCpB.start();;

        threadCpA.join();
        threadCpB.join();

    }
}
