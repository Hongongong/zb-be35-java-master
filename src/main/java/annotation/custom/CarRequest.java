package annotation.custom;

public class CarRequest {

    private final String model;
    private final String year;

    public CarRequest(String model, String year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }
}
