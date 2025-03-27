package annotation.general.safevarargs;

public class SafeVarargsExample {

    // 제네릭 가변 인자에 대한 경고를 무시함
    // 어노테이션 주석처리하면 경고 메세지 확인 가능
    // 실무에서 사용하는건 권장하지 않음, 경고 메세지 안나도록 하는게 우선
    @SafeVarargs
    public static <T> void printMessage(T... messages) {
        for (T message : messages) {
            System.out.println(message);
        }
    }

}
