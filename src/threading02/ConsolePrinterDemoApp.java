package threading02;

public class ConsolePrinterDemoApp {

    public static void main(String[] args) throws InterruptedException {


        ConsolePrinter cpA = new ConsolePrinter("A");
        ConsolePrinter cpB = new ConsolePrinter("B");

        Thread th1 = new Thread(cpA);
        Thread th2 = new Thread(cpB);

        th1.start();
        th2.start();

        System.out.println("all done");



    }
}
