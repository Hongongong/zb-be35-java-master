package annotation.custom;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomAnnotationMainTest {

    @Test
    public void testValidYearRange() {
        Car car = CarFactory.createCar(new CarRequest("BMW", 2021)); // 유효한 연도, 2000 ~ 2025 사이의 값이므로 정상적으로 생성되어야함
        assertThat(car.getYear()).isEqualTo(2021);

        System.out.println(car);
    }

    @Test
    public void testInvalidYearRange() {

        assertThatThrownBy(() -> CarFactory.createCar(new CarRequest("BMW", 2026))) // 유효하지 않은 연도, 2000 ~ 2025 사이의 값이 아니므로 예외 발생해야함
                .isInstanceOf(IllegalArgumentException.class);

    }

}