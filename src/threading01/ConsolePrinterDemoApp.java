package threading01;

public class ConsolePrinterDemoApp {

    public static void main(String[] args) throws InterruptedException {

        ConsolePrinter cpA = new ConsolePrinter("printer A");
        ConsolePrinter cpB = new ConsolePrinter("printer B");

        //cpA.logic();
        //cpB.logic();

        cpA.start();
        cpB.start();

        cpA.join(); // warten, bis Thread fertig ist
        cpB.join();

        System.out.println("all done");
    }
}
