import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Renting {

    private final Client client = new Client();
    private final Car car = new Car();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy 12:00");
    private final Scanner scan = new Scanner(System.in);

    public void process() {
        car.addCar(1, "BMW", "2022", BodyType.SEDAN, Transmission.AUTOMATIC, FuelType.GASOLINE, 170, 60);
        car.addCar(2, "Mercedes", "2023", BodyType.SEDAN, Transmission.AUTOMATIC, FuelType.DIESEL, 150, 65);
        car.addCar(3, "Audi", "2022", BodyType.STATION_WAGON, Transmission.AUTOMATIC, FuelType.GASOLINE, 190, 64);

        System.out.println("* * * Welcome to SKY Car Rental * * *");
        System.out.println();

        car.showCars();
        System.out.println();

        System.out.println(">> Enter your personal information: ");
        System.out.println();

        System.out.print("- Name: ");
        String name = scan.nextLine().toUpperCase().trim();
        client.setName(name);

        String phoneNumber = enterPhoneNumber();
        client.setPhoneNumber(phoneNumber);

        String emailAddress = enterEmailAddress();
        client.setEmail(emailAddress);

        System.out.println();
        System.out.print("- Please enter the id of the car you want to pick: ");
        int carId = scan.nextInt();

        for (Car c : car.getCars()) {
            if (c.getId() == carId) {
                client.setCar(c);
            }
        }

        System.out.println();
        System.out.print("- For how many day(s) do you want to rent the " + client.getCar().getModel() + "? ");
        int rentDays = scan.nextInt();

        LocalDateTime localDateTime = LocalDateTime.now().plusDays(rentDays);
        String formattedTime = localDateTime.format(formatter);

        System.out.println();
        clientInfo(formattedTime, rentDays);

        System.out.println();
        System.out.println("* Have a nice drive! *");
    }

    public String enterPhoneNumber() {
        while (true) {
            System.out.print("- Phone number: ");
            String phoneNumber = scan.nextLine();
            String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");

            if (digitsOnly.length() == 11) {
                return String.format(
                        "%s-%s-%s-%s",
                        digitsOnly.substring(0, 4),
                        digitsOnly.substring(4, 7),
                        digitsOnly.substring(7, 9),
                        digitsOnly.substring(9)
                );
            }

            System.out.println("> Invalid phone number! Try again.");
            System.out.println();
        }
    }

    public String enterEmailAddress() {
        while (true) {
            System.out.print("- Email address: ");
            String email = scan.nextLine();

            if (isValidEmailAddress(email)) {
                return email.toLowerCase();
            }

            System.out.println("> Invalid email address! Try again.");
            System.out.println();
        }
    }

    public boolean isValidEmailAddress(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$";
        return email.matches(regex);
    }

    public void clientInfo(String time, int days) {
        System.out.println("The car with id number [" + client.getCar().getId() + "] is rented by Mr&Mrs `" +
                client.getName() + "` until => " + time + ".");

        int totalPrice = days * client.getCar().getPrice();

        System.out.println("Total car rental fee for " + days + " day(s) is => " + totalPrice + "$.");
        System.out.println();

        System.out.println(">> Features of the rented vehicle:");
        System.out.println("- Model: " + client.getCar().getModel());
        System.out.println("- Model year: " + client.getCar().getModelYear());
        System.out.println("- Body type: " + client.getCar().getBodyType());
        System.out.println("- Transmission: " + client.getCar().getTransmission());
        System.out.println("- Fuel type: " + client.getCar().getFuelType());
        System.out.println("- Horse power: " + client.getCar().getHorsePower());
        System.out.println("- Daily rental fee: " + client.getCar().getPrice() + "$");
    }
}
