package functionalinterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        // Functional Interface : 하나의 추상 메소드만 존재하는 인터페이스
        // 활용 예시

        // Consumer : 입력값(매개변수) 있고 반환값은 없음
        // 문자열 s 받아서 "Consumer: " + s 출력하는 printConsumer 정의
        Consumer<String> printConsumer = (String s) -> System.out.println("Consumer: " + s);
        printConsumer.accept("안녕하세요"); // Consumer: 안녕하세요 출력

        // Supplier : 입력값 없이 결과값을 공급함
        // "공급된 문자열" 출력하는 stringSupplier 정의
        Supplier<String> stringSupplier = () -> "공급된 문자열";
        System.out.println("Supplier: " + stringSupplier.get()); // Supplier: 공급된 문자열 출력

        // Predicate : 입력값을 받아 boolean 값을 반환함
        // 짝수인지 확인하는 isEven 정의
        Predicate<Integer> isEven = (Integer n) -> n % 2 == 0;
        System.out.println("2는 짝수인가? " + isEven.test(2)); // 2는 짝수인가? true

        // Function : 입력값을 받아 다른 타입의 결과값을 반환함 (제일 다양하게 사용 가능)
        // 문자열 길이를 반환하는 stringLength 정의
        Function<String, Integer> stringLength = (String s) -> s.length(); // String::length 로 메서드 참조 형태로 바꿀수있음

        System.out.println("문자열 길이: " + stringLength.apply("안녕하세요")); // 문자열 길이: 5


    }

}
