package annotation.custom.validator;

import annotation.custom.CarRequest;
import annotation.custom.annotation.YearRange;

import java.lang.reflect.Field;

public class Validator {

    public static void validateYear(CarRequest request) {

        try {

            Field field = request.getClass().getDeclaredField("year"); // CarRequest 클래스 내 year 필드 가져옴
            field.setAccessible(true); // 원래 year 필드 private 이기때문에 일시적으로 접근할 수 있도록 설정
            YearRange yearRange = field.getAnnotation(YearRange.class); // field의 YearRagne 라는 어노테이션 가져옴

            int year = request.getYear(); // request 내 year 가져옴

            // 2000 ~ 2025 validation check
            if(year < yearRange.min() || year > yearRange.max()) { // 유효하지 않은 연도라면
                throw new IllegalArgumentException("Invalid year range"); // 예외 발생
            }

        } catch (NoSuchFieldException e) {
            throw new RuntimeException("No such field");
        }

    }

}
