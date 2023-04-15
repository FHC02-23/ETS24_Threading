package threading03;

public class PrimValidation implements Runnable {

    private final long number;

    public PrimStatus isPrim;
    public PrimValidation(long number) {
        this.number = number;
        isPrim = PrimStatus.NotStarted;
    }

    @Override
    public String toString() {
        return "PrimValidation{" +
                "number=" + number +
                ", isPrim=" + isPrim +
                '}';
    }

    private void validate(){

        isPrim = PrimStatus.Running;

        for (long i = 2; i < number; i++){
            if (number % i == 0) {
                isPrim = PrimStatus.IsNotPrim;
                break;
            }
        }

        if (isPrim == PrimStatus.Running)
            isPrim = PrimStatus.IsPrim;

        System.out.println("done: " + number + " is a Prim: " + isPrim);
    }

    @Override
    public void run() {
        validate();
    }
}
