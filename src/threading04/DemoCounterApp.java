package threading04;

public class DemoCounterApp {
    public static void main(String[] args) throws InterruptedException {

        Counter counter1 = new Counter();
        //Counter counter2 = new Counter();

        Thread th1 = new Thread(counter1);
        //Thread th2 = new Thread(counter2);


        th1.start();
        //th2.start();

        System.out.println("Thread läuft");
        Thread.sleep(20000);

        System.out.println("Thread höflich stoppen");
        th1.interrupt();
        //counter1.shouldRun = false;

        th1.join();
        System.out.println("Thread gestoppt");
        //th2.join();


        System.out.println("Counter.Counter = " + Counter.Counter);

    }
}
