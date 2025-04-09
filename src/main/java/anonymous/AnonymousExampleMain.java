package anonymous;

public class AnonymousExampleMain {

    public static void main(String[] args) {

        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.sound(); // 멍멍
        cat.sound(); // 야옹

        // 익명 클래스
        // 코드 실행되는 시점에 빌드됨 (필요한 시점에 메모리 소모)
        Animal crow = new Animal() {
            @Override
            public void sound() {
                System.out.println("까악");
            }
        };

        crow.sound(); // 까악'

        Animal sparrow = new Animal() {
            @Override
            public void sound() {
                System.out.println(soundString() + soundString());
            }

            // soundString 메소드 추가
            // 익명 클래스 종료되면 호출 불가
            public String soundString() {
                return "짹짹";
            }

        };

        sparrow.sound(); // 짹짹
        // sparrow.soundString(); // 해당 메소드 없다고 에러 발생

    }

}
