package threading05;

public class DemoCounterApp {
    public static void main(String[] args) throws InterruptedException {

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        
        Thread th1 = new Thread(counter1);
        Thread th2 = new Thread(counter2);

        th1.start(); th2.start();

        th1.join();th2.join();


        System.out.println("Counter.Counter = " + Counter.Counter);

    }
}
