package functionalinterface.compare;

// Comparable<T> : 객체를 비교하는 메소드 compareTo()가 존재하는 인터페이스
public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // compareTo() 메소드 구현
    // Comparable<T> 인터페이스를 구현한 클래스는 compareTo() 메소드를 구현해야 함
    // compareTo() 메소드는 자기자신과 다른 객체를 비교하는 메소드
    // 반환값은 int로, 0보다 작으면 자기자신이 작음, 0이면 같음, 0보다 크면 자기자신이 큼
    @Override
    public int compareTo(Student other) {
       // score로 비교
        return Integer.compare(this.score, other.score);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

}
