package annotation.custom;

public class Car {

    private final String model;
    private final String year;

    public Car(String model, String year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
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
