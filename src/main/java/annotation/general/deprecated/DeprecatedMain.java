package annotation.general.deprecated;

public class DeprecatedMain {

    public static void main(String[] args) {

        OldLibrary oldLibrary = new OldLibrary();
        // Deprecated 어노테이션 달린 메소드라서 경고(warning) 메세지 뜸
        // 사용자가 사용하지 않도록 유도하지만 작동은 함
        oldLibrary.printMessage(); // I'm old library

        NewLibrary newLibrary = new NewLibrary();
        newLibrary.printMessage(); // I'm new library
    }

}
