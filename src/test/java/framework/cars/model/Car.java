package framework.cars.model;

/**
 * Created by User on 21.06.2017.
 */
public class Car {

    private String make;
    private String model;
    private String year;
    private String engine;
    private String transmission;

    public Car() {
    }

    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Car(String engine, String transmission) {
        this.engine = engine;
        this.transmission = transmission;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (year != car.year) return false;
        if (!make.equals(car.make)) return false;
        if (!model.equals(car.model)) return false;
        if (!engine.equals(car.engine)) return false;
        return transmission.equals(car.transmission);
    }

    @Override
    public int hashCode() {
        int result = make.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + year.hashCode();
        result = 31 * result + engine.hashCode();
        result = 31 * result + transmission.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                '}';
    }

}
