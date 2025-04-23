package stream;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperaionTest {

    // Faker 라이브러리 : 가짜 데이터 생성 라이브러리
    private final Faker faker = new Faker();

    /*
    * 1 ~ 10 사이의 숫자에서 짝수만 필터링
    * */

    // filter() 메소드
    // 스트림에서 조건에 맞는 요소만 추출하는 중간연산 메소드
    // Predicate<T> 인터페이스를 인자로 받음
    // Predicate<T> 인터페이스는 test() 메소드를 가지고 있음
    // test() 메소드는 T 타입의 객체를 인자로 받아 boolean 값을 반환함
    // filter() 메소드는 test() 메소드가 true인 요소만 추출함
    @Test
    void filter() {

        // 숫자 리스트 생성 후 스트림으로 변환해서 필터 연산

        // 1 ~ 10 사이의 숫자 리스트 생성
        // - 정적인 방법
        // List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // - 동적인 방법
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        // 리스트 그 자체로는 스트림 연산 불가하기때문에
        // .stream()으로 스트림 변환
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0) // 짝수만 필터링하는 스트림 중간 연산
                .toList(); // true 인 요소만 List로 변환

        System.out.println(evenNumbers); // [2, 4, 6, 8, 10] 출력


        // 스트림으로 바로 생성해서 필터 연산

        // IntStream.rangeClosed(1, 10) : int 스트림 생성해서 1부터 10까지의 숫자 넣음
        List<Integer> evenNumbers2 = IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0) // 짝수만 필터링하는 스트림 중간 연산
                .boxed() // IntStream을 Stream<Integer>로 변환
                .toList(); // true 인 요소만 List로 변환

        System.out.println(evenNumbers2); // [2, 4, 6, 8, 10] 출력

    }

    // map() 메소드
    // 스트림에서 요소를 변환하는 중간연산 메소드
    // Function<T, R> 인터페이스를 인자로 받음
    // Function<T, R> 인터페이스는 apply() 메소드를 가지고 있음
    // apply() 메소드는 T 타입의 객체를 인자로 받아 R 타입의 객체를 반환함
    // map() 메소드는 apply() 메소드가 호출된 요소를 변환함
    @Test
    void map() {

        /*
         * 10명의 이름 리스트에서 이름 -> 이름 길이로 변환
         * */

        // 10명 이름 스트림 생성 후 리스트로 변환
        List<String> names = Stream.generate(() -> faker.name().firstName())
                .limit(10) // 10개만 생성
                .toList();

        System.out.println(names); // [이름1, 이름2, 이름3, 이름4, 이름5, 이름6, 이름7, 이름8, 이름9, 이름10] 출력

        // stream()으로 변환해서 map 연산
        List<Integer> nameLengths = names.stream()
                .map((String s) -> s.length()) // 이름 -> 이름 길이로 변환
                .toList();

        System.out.println(nameLengths); // [이름1 길이, 이름2 길이, 이름3 길이, 이름4 길이, 이름5 길이, 이름6 길이, 이름7 길이, 이름8 길이, 이름9 길이, 이름10 길이] 출력

    }

    @Test
    void mapVsFlatMap() {

        /*
        * 랜덤한 10명의 이름을 받아서 그 이름을 한글자씩 나눈 List를 만든다.
        * 그리고 map, flatMap의 차이를 확인한다.
        * */

        // 10명 이름 스트림 생성 후 리스트로 변환
        List<String> names = Stream.generate(() -> faker.name().firstName())
                .limit(10) // 10개만 생성
                .toList(); // 리스트로 변환
        System.out.println(names); // [이름1, 이름2, 이름3, 이름4, 이름5, 이름6, 이름7, 이름8, 이름9, 이름10] 출력

        // map() 메소드 사용
        List<List<String>> nameCharacters = names.stream()
                .map(s -> List.of(s.split(""))) // 이름 -> 이름 한글자씩 나눈 "리스트"로 변환
                .toList(); // 리스트로 변환
        System.out.println(nameCharacters); // [[이, 름1], [이, 름2], [이, 름3], [이, 름4], [이, 름5], [이, 름6], [이, 름7], [이, 름8], [이, 름9], [이, 름10]] 출력
        // map 사용 시에는 리스트 안에 리스트가 들어가게 됨

        // flatMap() 메소드 사용
        List<String> nameCharacters2 = names.stream()
                .flatMap(s -> Stream.of(s.split(""))) // 이름 -> 이름 한글자씩 나눈 "스트림"으로 변환
                .toList(); // 리스트로 변환
        System.out.println(nameCharacters2); // [이, 름1, 이, 름2, 이, 름3, 이, 름4, 이, 름5, 이, 름6, 이, 름7, 이, 름8, 이, 름9, 이, 름10] 출력
        // fatMap 사용 시에는 쭉 연결된 리스트로 변환됨 (평탄화됨)

    }


}
