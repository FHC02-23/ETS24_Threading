package threading03;

public class PrimValidiationDemoApp {

    //1979990039, 1989990047, 1991990059, 1891999939, 1891999943, 1991999993
    public static void main(String[] args) throws InterruptedException {

        PrimValidation prim1 = new PrimValidation(1979990039);
        PrimValidation prim2 = new PrimValidation(1989990047);
        PrimValidation prim3 = new PrimValidation(1991990059);
        PrimValidation prim4 = new PrimValidation(1891999939);
        PrimValidation prim5 = new PrimValidation(1891999943);
        PrimValidation prim6 = new PrimValidation(1991999993);
        PrimValidation prim7 = new PrimValidation(1991999999);

        //prim1.validate();
        //System.out.println(prim1.isPrim);

        Thread th1 = new Thread(prim1);
        Thread th2 = new Thread(prim2);
        Thread th3 = new Thread(prim3);
        Thread th4 = new Thread(prim4);
        Thread th5 = new Thread(prim5);
        Thread th6 = new Thread(prim6);
        Thread th7 = new Thread(prim7);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
        th7.start();

        
        th1.join();
        th2.join();
        th3.join();
        th4.join();
        th5.join();
        th6.join();
        th7.join();

        System.out.println("prim1 = " + prim1);
        System.out.println("prim2 = " + prim2);
        System.out.println("prim3 = " + prim3);
        System.out.println("prim4 = " + prim4);
        System.out.println("prim5 = " + prim5);
        System.out.println("prim6 = " + prim6);
        System.out.println("prim7 = " + prim7);

    }
}
