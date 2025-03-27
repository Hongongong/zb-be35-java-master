package annotation.custom;

import annotation.custom.annotation.YearRange;

public class Car {

    private final String model;
    // 2000 ~ 2025 내 차량만 정상인걸로
    @YearRange(min = 2000, max = 2025)
    private final Integer year;

    public Car(String model, Integer year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
