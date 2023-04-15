package threading03;

public class PrimValidation {

    private final long number;

    public boolean isPrim;
    public PrimValidation(long number) {
        this.number = number;
        isPrim = false;
    }

    @Override
    public String toString() {
        return "PrimValidation{" +
                "number=" + number +
                ", isPrim=" + isPrim +
                '}';
    }

    public void validate(){

        isPrim = true;

        for (long i = 2; i < number; i++){
            if (number % i == 0) {
                isPrim = false;
                break;
            }
        }

        System.out.println("done: " + number + " is a Prim: " + isPrim);
    }

}
