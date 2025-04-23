package functionalinterface.thread;

public class RunnableExample {

    public static void main(String[] args) {

        // Runnable은 functional interface
        // run() 메소드가 하나만 존재 - 매개변수, 반환값 x
        // 반환값 없으므로 출력 등 단순 작업하는 경우 적합
        Runnable task = () -> System.out.println("Hello, Wolrd!");

        Thread thread = new Thread(task);
        thread.start();

    }

}
