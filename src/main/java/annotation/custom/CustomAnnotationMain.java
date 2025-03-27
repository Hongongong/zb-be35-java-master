package annotation.custom;

public class CustomAnnotationMain {

    public static void main(String[] args) {

        // CarFactory 클래스에서 car 객체 만들어 가져옴
        Car car = CarFactory.createCar(new CarRequest("BMW", 2021));
        System.out.println(car);

    }

}
