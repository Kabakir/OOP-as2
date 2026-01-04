import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.Year;

/* ===== INTERFACE ===== */
interface Servicable {
    void performService();
    int getServiceIntervalKm();
}

/* ===== ABSTRACT CLASS ===== */
abstract class Vehicle implements Servicable {
    private int id;
    private static int idGen = 1;
    private String model;
    private int year;
    private double basePrice;

    public Vehicle(String model, int year, double basePrice) {
        this.id = idGen++;
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model is incorrect");
        }
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1886 || year > currentYear) {
            throw new IllegalArgumentException("Year is incorrect");
        }
        this.year = year;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        this.basePrice = basePrice;
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return "ID: " + id +
                ", Model: " + model +
                ", Year: " + year +
                ", Price: " + basePrice;
    }
}

/* ===== CAR ===== */
class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        return getBasePrice() * 0.05 +
                getAge(Year.now().getValue()) * 10;
    }

    @Override
    public void performService() {
        System.out.println("Car " + getModel() +
                ": oil change and tire check");
    }

    @Override
    public int getServiceIntervalKm() {
        return 10000;
    }
}

/* ===== BUS ===== */
class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        return getBasePrice() * 0.08;
    }

    @Override
    public void performService() {
        System.out.println("Bus " + getModel() +
                ": full technical inspection");
    }

    @Override
    public int getServiceIntervalKm() {
        return 20000;
    }
}

/* ===== CONSOLE APPLICATION ===== */
public class FleetApp {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\nFleet Management System");
            System.out.println("1. Print all vehicles");
            System.out.println("2. Add new car");
            System.out.println("3. Add new bus");
            System.out.println("4. Show total insurance fees");
            System.out.println("5. Show vehicles older than N years");
            System.out.println("6. Perform service for all vehicles");
            System.out.println("7. Quit");

            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
switch (choice) {
        case 1 -> printVehicles();
                case 2 -> addCar();
                case 3 -> addBus();
                case 4 -> showTotalInsurance();
                case 5 -> showOlderThanN();
                case 6 -> performAllService();
                case 7 -> {
                        System.out.println("Goodbye!");
                    return;
                            }
default -> System.out.println("Wrong option");
            }
                    }
                    }

private void printVehicles() {
    if (vehicles.isEmpty()) {
        System.out.println("No vehicles in the fleet");
    } else {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}

private void addCar() {
    System.out.print("Model: ");
    String model = scanner.nextLine();
    System.out.print("Year: ");
    int year = scanner.nextInt();
    System.out.print("Price: ");
    double price = scanner.nextDouble();
    System.out.print("Doors: ");
    int doors = scanner.nextInt();
    scanner.nextLine();

    vehicles.add(new Car(model, year, price, doors));
}

private void addBus() {
    System.out.print("Model: ");
    String model = scanner.nextLine();
    System.out.print("Year: ");
    int year = scanner.nextInt();
    System.out.print("Price: ");
    double price = scanner.nextDouble();
    System.out.print("Capacity: ");
    int capacity = scanner.nextInt();
    scanner.nextLine();

    vehicles.add(new Bus(model, year, price, capacity));
}

private void showTotalInsurance() {
    double total = 0;
    for (Vehicle v : vehicles) {
        total += v.calculateInsuranceFee();
    }
    System.out.println("Total insurance fees: " + total);
}

private void showOlderThanN() {
    System.out.print("Current year: ");
    int currentYear = scanner.nextInt();
    System.out.print("N: ");
    int n = scanner.nextInt();

    for (Vehicle v : vehicles) {
        if (v.getAge(currentYear) > n) {
            System.out.println(v);
        }
    }
}

private void performAllService() {
    for (Vehicle v : vehicles) {
        v.performService(); // polymorphism
    }
}

public static void main(String[] args) {
    new FleetApp().run();
}
}