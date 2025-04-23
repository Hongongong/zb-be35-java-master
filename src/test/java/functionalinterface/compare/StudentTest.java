package functionalinterface.compare;

import net.datafaker.Faker;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@TestMethodOrder(value = MethodOrderer.MethodName.class) // 메소드 이름으로 정렬하는 어노테이션
class StudentTest {

    // Faker 라이브러리 : 가짜 데이터 생성 라이브러리
    private final Faker faker = new Faker();

    // faker 라이브러리 활용해서 Student 객체 생성하는 Supplier
    private final Supplier<Student> getStudent = () -> new Student(faker.name().firstName(), faker.number().numberBetween(0, 100));
    // Student 객체 20개 생성
    private final Supplier<List<Student>> getStudents = () ->
            IntStream.range(0, 20).mapToObj(i -> getStudent.get()).collect(Collectors.toCollection(ArrayList::new));

    @Test
    void testComparable() {
        Student student1 = getStudent.get();
        Student student2 = getStudent.get();

        System.out.println(student1 + " vs " + student2); // 학생 정보 출력
        System.out.println(student1.compareTo(student2)); // student1이 student2보다 작으면 -1, 같으면 0, 크면 1
    }

    // 점수 기준으로 학생 리스트 정렬
    @Test
    void testComparableSort() {
        List<Student> students = getStudents.get();

        System.out.println("### Before Sort ###");
        students.forEach(System.out::println); // 학생 정보 출력

        System.out.println("### After Sort ###");
        students.sort(Student::compareTo); // 점수 기준으로 학생 리스트 정렬
        students.forEach(System.out::println); // 학생 정보 출력
    }

    // 역순 정렬
    @Test
    void testComparableReverseSort() {
        List<Student> students = getStudents.get();

        System.out.println("### Before Sort ###");
        students.forEach(System.out::println); // 학생 정보 출력

        System.out.println("### After Sort ###");
        Collections.sort(students, Collections.reverseOrder()); // 점수 기준으로 학생 리스트 역순 정렬
        students.forEach(System.out::println); // 학생 정보 출력
    }

    @Test
    void testComparator() {
        Student student1 = getStudent.get();
        Student student2 = getStudent.get();

        System.out.println(student1 + " vs " + student2); // 학생 정보 출력
        System.out.println(new NameComparator().compare(student1, student2)); // student1 이름 첫째자리 알파벳 - student2 이름 첫째자리 알파벳 값 출력
    }

    // 이름 기준으로 학생 리스트 정렬
    @Test
    void testComparatorSort() {
        List<Student> students = getStudents.get();

        System.out.println("### Before Sort ###");
        students.forEach(System.out::println); // 학생 정보 출력

        System.out.println("### After Sort ###");
        students.sort(new NameComparator()); // 이름 기준으로 학생 리스트 정렬
        students.forEach(System.out::println); // 학생 정보 출력
    }

    // 역순 정렬
    @Test
    void testComparatorReverseSort() {
        List<Student> students = getStudents.get();

        System.out.println("### Before Sort ###");
        students.forEach(System.out::println); // 학생 정보 출력

        System.out.println("### After Sort ###");
        // Comparator 함수형 인터페이스에 reversed() 메소드를 내장되어있어 바로 사용 가능
        students.sort(new NameComparator().reversed()); // 이름 기준으로 학생 리스트 역순 정렬
        students.forEach(System.out::println); // 학생 정보 출력
    }

}