package functionalinterface.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    // Callable은 functional interface
    // call() 메소드가 하나만 존재 - 매개변수 x, 반환값 o
    // Runnalble과 달리 반환값 받아서 다른 작업 진행 가능
    public static void main(String[] args) {

        // 메인 스레드에 의존하지 않고 별도의 스레드에서 작업을 수행
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Callable<String>은 call() 메소드가 String을 반환하는 메소드
        Callable<String> task = () -> "result123";

        // 별도로 만든 스레드에 task를 전달
        // submit() 메소드는 Future<T>를 반환
        Future<String> future = executor.submit(task);

        try {
            System.out.println("Callable Result = " + future.get()); // Callable Result = result123
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();

    }

}
