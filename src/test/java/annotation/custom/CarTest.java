package annotation.custom;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void testGetModelIonic() {
        Car car = new Car("Ionic", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelSonata() {
        Car car = new Car("Sonata", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelGrandeur() {
        Car car = new Car("Grandeur", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelAvante() {
        Car car = new Car("Avante", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelMorning() {
        Car car = new Car("Morning", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelNoMessage() {
        Car car = new Car("SM5", 2021); // 현대 차가 아니면 아무 메세지도 안뜨게
        car.getModel();
    }

}