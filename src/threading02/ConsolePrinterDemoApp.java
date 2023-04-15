package threading02;

public class ConsolePrinterDemoApp {

    public static void main(String[] args) throws InterruptedException {


        ConsolePrinter cpA = new ConsolePrinter("A");
        ConsolePrinter cpB = new ConsolePrinter("B");

        Thread threadCpA = new Thread(cpA);
        Thread threadCpB = new Thread(cpB);

        threadCpA.start();
        threadCpB.start();


        System.out.println("warten, warten");
        Thread.sleep(10000);
        System.out.println("After sleep");
        cpA.stopRunning();
        cpB.stopRunning();

        threadCpB.stop();

        threadCpA.join();
        threadCpB.join();



    }
}
