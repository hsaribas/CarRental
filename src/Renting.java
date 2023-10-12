import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Renting {

    private final Client client = new Client();
    private final Car car = new Car();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private final Scanner scan = new Scanner(System.in);

    public void process() {
        car.addCar(1, "BMW", "2022", BodyType.SEDAN, Transmission.AUTOMATIC, FuelType.GASOLINE, 170, 60);
        car.addCar(2, "Mercedes", "2023", BodyType.SEDAN, Transmission.AUTOMATIC, FuelType.DIESEL, 150, 65);
        car.addCar(3, "Audi", "2022", BodyType.STATION_WAGON, Transmission.AUTOMATIC, FuelType.GASOLINE, 190, 64);

        System.out.println("* * * Welcome to SKY Car Rental * * *");
        System.out.println();

        car.showCars();
        System.out.println();

        System.out.println(">> We need couple information for renting.");
        System.out.println();

        System.out.print("- Enter your name: ");
        String name = scan.nextLine();
        client.setName(name);

        System.out.print("- Enter your phone number: ");
        String phoneNumber = scan.nextLine();
        client.setPhoneNumber(phoneNumber);

        System.out.print("- Enter your email address: ");
        String email = scan.nextLine();
        client.setEmail(email);

        System.out.println();
        System.out.print("- Please enter the id of the car you want to pick: ");
        int carId = scan.nextInt();

        for(Car c : car.getCars()) {
            if(c.getId() == carId) {
                client.setCar(c);
            }
        }

        System.out.println("");
    }
}
