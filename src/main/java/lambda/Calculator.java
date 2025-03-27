package lambda;

public class Calculator {
    private final int a;
    private final int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int calculate(Operate operate) {
        return operate.operate(a, b);
    }
}
