package annotation.custom;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/*
* Reflection 사용 예제
* */

class CarPrivateMethodTest {

    // Car 클래스의 private 메소드인 isNeedMaintenance()를 테스트하는 코드
    // 자돋차 생산된지 5년 넘어 정비 필요한 경우
    @Test
    public void needMaintenance() throws Exception {

        int yearMaintenance = LocalDate.now().getYear() - 6; // 현재년도 - 6
        Car carMaintenance = new Car("TestModel", yearMaintenance); // 2019년도 자동차 객체 생성

        // 테스트하려는 메소드 이름 수동으로 입력해서 가져옴
        Method method = Car.class.getDeclaredMethod("isNeedMaintenance");
        // private 메소드이므로 접근 가능하도록 설정
        // 코드 길어져서 안정성, 성능 낮아짐
        // 테스트에서만 주로 사용
        method.setAccessible(true);
        boolean resultMaintenance = (boolean) method.invoke(carMaintenance); // 메소드 실행시켜서 결과 가져옴

        assertThat(resultMaintenance).isTrue(); // 정비 필요하므로 true

    }

    // 정비 필요하지 않은 경우
    @Test
    public void notNeedMaintenance() throws Exception {

        int yearMaintenance = LocalDate.now().getYear() - 4; // // 현재년도 - 4
        Car carMaintenance = new Car("TestModel", yearMaintenance); // 2021년도 자동차 객체 생성

        // 테스트하려는 메소드 이름 수동으로 입력해서 가져옴
        Method method = Car.class.getDeclaredMethod("isNeedMaintenance");
        // private 메소드이므로 접근 가능하도록 설정
        method.setAccessible(true);
        boolean resultMaintenance = (boolean) method.invoke(carMaintenance); // 메소드 실행시켜서 결과 가져옴

        assertThat(resultMaintenance).isFalse(); // 정비 필요하지 않으므로 false

    }

    // 오일 교체 필요한 경우
    @Test
    public void needChangeOil() {

        int yearChangeOil = LocalDate.now().getYear() - 1;
        Car carChangeOil = new Car("TestModel", yearChangeOil);

        // public 메소드는 직접 호출 가능하기 때문에 코드 간결
        // 안정성 높음
        boolean resultChangeOil = carChangeOil.isNeedChangeOil();

        assertThat(resultChangeOil).isTrue();

    }

    // 오일 교체 필요하지 않은 경우
    @Test
    public void notNeedChangeOil() {

        int yearChangeOil = LocalDate.now().getYear();
        Car carChangeOil = new Car("TestModel", yearChangeOil);

        boolean resultChangeOil = carChangeOil.isNeedChangeOil();

        assertThat(resultChangeOil).isFalse();

    }

}