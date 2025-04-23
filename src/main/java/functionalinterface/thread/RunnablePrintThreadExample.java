package functionalinterface.thread;

public class RunnablePrintThreadExample {

    public static void main(String[] args) {

        // Runnable은 functional interface
        // run() 메소드가 하나만 존재 - 매개변수, 반환값 x
        // 반환값 없으므로 출력 등 단순 작업하는 경우 적합
        Runnable task = () -> System.out.println("[" + Thread.currentThread().getName() + "] Runnable Thread");
        // [Thread-0] Runnable Thread 출력

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("[" + Thread.currentThread().getName() + "] Hello, Wolrd!");
        // [main] Hello, Wolrd! 출력

        Thread thread2 = new Thread(task);
        thread2.start();
        // [Thread-1] Runnable Thread 출력

        Thread thread3 = new Thread(task);
        thread3.start();
        // [Thread-2] Runnable Thread 출력

    }

}
