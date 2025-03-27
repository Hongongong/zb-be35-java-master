package annotation.custom;

import annotation.custom.annotation.ModelDescriptionPrint;
import annotation.custom.annotation.ModelDescriptionPrints;
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

    // print model description
    // Ionic: new model
    // Sonata: steady seller
    // Grandeur: luxury model
    // Avante: compact model
    // Morning: small car
    @ModelDescriptionPrints({
            @ModelDescriptionPrint(model = "Ionic", description = "new model"),
            @ModelDescriptionPrint(model = "Sonata", description = "steady seller"),
            @ModelDescriptionPrint(model = "Grandeur", description = "luxury model"),
            @ModelDescriptionPrint(model = "Avante", description = "compact model"),
            @ModelDescriptionPrint(model = "Morning", description = "small car")
    })
    public String getModel() {

        try {
            // 여기 클래스에서 getModel 메소드를 가져와 ModelDescriptionPrint 어노테이션들을 가져옴 -> 복수개니까 배열 형태로 받음
            ModelDescriptionPrint[] annotations = this.getClass().getMethod("getModel").getAnnotationsByType(ModelDescriptionPrint.class);
            // for-each로 순회하면서 현재 car 객체와 같은 model 어노테이션의 description을 출력
            for (ModelDescriptionPrint annotation : annotations) {
                if (annotation.model().equals(model)) {
                    System.out.println(annotation.description()); // 어노테이션의 description 출력
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

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
