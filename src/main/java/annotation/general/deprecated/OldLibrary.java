package annotation.general.deprecated;

public class OldLibrary {

    @Deprecated // 사라질 기능이다, 사용하지 말라는 의미
    public void printMessage() {

        System.out.println("I'm old library");

    }

}
