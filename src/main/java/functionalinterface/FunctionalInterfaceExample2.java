package functionalinterface;


import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

public class FunctionalInterfaceExample2 {

    public static void main(String[] args) {

        // Functional Interface : 하나의 추상 메소드만 존재하는 인터페이스
        // 활용 예시

        // BiConsumer : 입력값 두 개 받아 처리만 하고 반환값은 없음
        BiConsumer<String, Integer> biConsumer = (String s, Integer i) -> System.out.println(s + " " + i);
        biConsumer.accept("안녕하세요", 5); // 안녕하세요 5 출력

        // BiFunction : 입력값을 두 개 받아 결과값을 반환함
        BiFunction<Integer, Integer, String> biFunction = (Integer a, Integer b) -> "결과: " + (a + b);
        String result1 = biFunction.apply(10, 20);
        System.out.println(result1); // 결과: 30 출력

        // BinaryOperator : 입력값을 두 개 받아 같은 타입의 결과값을 반환함
        // <T>는 제네릭 타입으로, 무슨 타입이든 상관없음, 다만 같은 타입이어야 함 (다른 타입이면 T,U,R 등으로 나눠야 함)
        BinaryOperator<Integer> binaryOperator = (Integer a, Integer b) -> a + b;
        int result2 = binaryOperator.apply(3, 4);
        System.out.println("곱셈 결과 : " + result2); // 곱셈 결과 : 7 출력

        // BiPredicate : 입력값을 두 개 받아 boolean 값을 반환함
        BiPredicate<String, String> biPredicate = (String s1, String s2) -> s1.equals(s2);
        boolean isEqual = biPredicate.test("테스트", "테스트");
        System.out.println("문자열 비교 결과 : " + isEqual); // 문자열 비교 결과 : true 출력




    }

}
