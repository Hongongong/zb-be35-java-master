package lambda;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator(10, 20);
        // 익명클래스 사용
        int result = calculator.calculate(
                // Operate 인터페이스를 구현한 익명 클래스
                new Operate() {
                    @Override
                    public int operate(int a, int b) {
                        return a + b;
                    }
                }
        );

        System.out.println("Anonymous Class result = " + result);
    }

    @Test
    void testAddLambda() {
        Calculator calculator = new Calculator(15, 20);
        // 람다식으로 Operate 인터페이스 구현 방법 1 - 메서드 매개변수로 바로 람다 작성
        int result = calculator.calculate((a, b) -> a + b);

        System.out.println("Lambda 1 result = " + result);
    }

    @Test
    void testAddLambda2() {
        Calculator calculator = new Calculator(10, 30);

        // 람다식으로 Operate 인터페이스 구현 방법 2 - 람다를 함수로 만들어서 매개변수로 넣음
        Operate operate = (int a, int b) -> a + b;

        int result = calculator.calculate(operate);

        System.out.println("Lambda 2 result = " + result);
    }

    @Test
    void testAddLambda3() {
        Calculator calculator = new Calculator(10, 50);

        // 람다식으로 Operate 인터페이스 구현 방법 3 - 메서드 참조 (자바 내부 구현되있음)
        int result = calculator.calculate(Integer::sum);

        System.out.println("Lambda 3 result = " + result);
    }

    @Test
    void testAddLambda4() {
        Calculator calculator = new Calculator(10, 60);

        // 람다식으로 Operate 인터페이스 구현 방법 4 - 람다 사용한 메서드 만들어서 메서드를 매개변수로 넣음
        int result = calculator.calculate(getOperate());

        System.out.println("Lambda 4 result = " + result);
    }

    private Operate getOperate() {
        // return (int a, int b) -> a + b;
        // 위와 같은 표현
        return Integer::sum;
    }

    @Test
    void testSubstract() {
        Calculator calculator = new Calculator(20, 10);
        // 람다 사용 ( 빼기는 메서드 참조 지원 안됨)
        int result = calculator.calculate((int a, int b) -> a - b);

        System.out.println("Anonymous Class result = " + result);
    }

}