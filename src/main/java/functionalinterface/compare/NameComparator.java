package functionalinterface.compare;

import java.util.Comparator;

// Comparator<T> : 객체를 비교하는 메소드 compare()가 존재하는 인터페이스
public class NameComparator implements Comparator<Student> {

    // compare() 메소드 구현
    // Comparator<T> 인터페이스를 구현한 클래스는 compare() 메소드를 구현해야 함
    // compare() 메소드는 두 객체를 비교하는 메소드
    // 반환값은 int로, 0보다 작으면 첫번째 객체가 작음, 0이면 같음, 0보다 크면 두번째 객체가 큼
    @Override
    public int compare(Student o1, Student o2) {
        // 이름으로 비교
        return o1.getName().compareTo(o2.getName());
    }

}
