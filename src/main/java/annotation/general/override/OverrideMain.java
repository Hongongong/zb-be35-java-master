package annotation.general.override;

public class OverrideMain {

    public static void main(String[] args) {

        Parent p1 = new Parent();
        p1.printMessage(); // I'm parent class
        p1.printMessageNotOverride(); // I'm parent class [not override]

        Parent p2 = new Child();
        p2.printMessage(); // I'm child class
        p2.printMessageNotOverride(); // I'm parent class [not override]

    }

}
