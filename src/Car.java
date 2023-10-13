import java.util.HashSet;
import java.util.Set;

public class Car {

    private int id;
    private String model;
    private String modelYear;
    private BodyType bodyType;
    private Transmission transmission;
    private FuelType fuelType;
    private int horsePower;
    private int price;
    private final Set<Car> cars = new HashSet<>();

    public Car() {
    }

    public Car(int id, String model, String modelYear, BodyType bodyType, Transmission transmission,
               FuelType fuelType, int horsePower, int price) {
        this.id = id;
        this.model = model;
        this.modelYear = modelYear;
        this.bodyType = bodyType;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.horsePower = horsePower;
        this.price = price;
    }

    public void addCar(int id, String model, String modelYear, BodyType bodyType, Transmission transmission,
                       FuelType fuelType, int horsePower, int price) {
        Car car = new Car(id, model, modelYear, bodyType, transmission, fuelType, horsePower, price);
        cars.add(car);
    }

    public void showCars() {
        System.out.println("<< Available rental vehicles >>");
        System.out.println("-------------------------------");

        for (Car car : this.cars) {
            System.out.println("- Id: " + car.getId());
            System.out.println("- Model: " + car.getModel());
            System.out.println("- Model Year: " + car.getModelYear());
            System.out.println("- Body Type: " + car.getBodyType());
            System.out.println("- Transmission: " + car.getTransmission());
            System.out.println("- Fuel Type: " + car.getFuelType());
            System.out.println("- Horse Power: " + car.getHorsePower());
            System.out.println("- Daily Rental Fee: " + car.getPrice());
            System.out.println("-------------------------------");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<Car> getCars() {
        return cars;
    }
}
