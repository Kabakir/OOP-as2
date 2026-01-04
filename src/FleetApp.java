import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.Year;

/**
 * Console application for managing a fleet of vehicles.
 * Demonstrates inheritance, polymorphism, and interface implementation.
 */
public class FleetApp {
    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    /**
     * Main method to run the application.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        FleetApp app = new FleetApp();
        app.run();
    }

    /**
     * Main application loop that displays menu and handles user input.
     */
    public void run() {
        System.out.println("=== Fleet Management System ===");
        
        while (true) {
            printMenu();
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                
                switch (choice) {
                    case 1 -> printVehicles();
                    case 2 -> addCar();
                    case 3 -> addBus();
                    case 4 -> showTotalInsurance();
                    case 5 -> showOlderThanN();
                    case 6 -> performAllService();
                    case 7 -> {
                        System.out.println("\nThank you for using Fleet Management System. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please choose 1-7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Prints the main menu.
     */
    private void printMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Fleet Management System");
        System.out.println("=".repeat(40));
        System.out.println("1. Print all vehicles");
        System.out.println("2. Add new car");
        System.out.println("3. Add new bus");
        System.out.println("4. Show total yearly insurance fees");
        System.out.println("5. Show vehicles older than N years");
        System.out.println("6. Perform service for all vehicles");
        System.out.println("7. Quit");
        System.out.println("=".repeat(40));
    }

    /**
     * Prints all vehicles in the fleet.
     */
    private void printVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("\nNo vehicles in the fleet.");
        } else {
            System.out.println("\n=== Fleet Vehicles ===");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
            System.out.println("Total vehicles: " + vehicles.size());
        }
    }

    /**
     * Adds a new car to the fleet.
     * Prompts user for car details and validates input.
     */
    private void addCar() {
        try {
            System.out.println("\n=== Add New Car ===");
            System.out.print("Enter model: ");
            String model = scanner.nextLine().trim();
            
            System.out.print("Enter year: ");
            int year = Integer.parseInt(scanner.nextLine().trim());
            
            System.out.print("Enter base price: ");
            double price = Double.parseDouble(scanner.nextLine().trim());
            
            System.out.print("Enter number of doors: ");
            int doors = Integer.parseInt(scanner.nextLine().trim());
            
            Car car = new Car(model, year, price, doors);
            vehicles.add(car);
            System.out.println("Car added successfully! ID: " + car.getId());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please try again.");
        }
    }

    /**
     * Adds a new bus to the fleet.
     * Prompts user for bus details and validates input.
     */
    private void addBus() {
        try {
            System.out.println("\n=== Add New Bus ===");
            System.out.print("Enter model: ");
            String model = scanner.nextLine().trim();
            
            System.out.print("Enter year: ");
            int year = Integer.parseInt(scanner.nextLine().trim());
            
            System.out.print("Enter base price: ");
            double price = Double.parseDouble(scanner.nextLine().trim());
            
            System.out.print("Enter passenger capacity: ");
            int capacity = Integer.parseInt(scanner.nextLine().trim());
            
            Bus bus = new Bus(model, year, price, capacity);
            vehicles.add(bus);
            System.out.println("Bus added successfully! ID: " + bus.getId());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please try again.");
        }
    }

    /**
     * Calculates and displays the total yearly insurance fees for all vehicles.
     * Demonstrates polymorphism through calculateInsuranceFee().
     */
    private void showTotalInsurance() {
        if (vehicles.isEmpty()) {
            System.out.println("\nNo vehicles in the fleet. Total insurance fees: 0.00");
            return;
        }
        
        double total = 0.0;
        for (Vehicle vehicle : vehicles) {
            total += vehicle.calculateInsuranceFee();
        }
        
        System.out.println("\n=== Total Yearly Insurance Fees ===");
        System.out.printf("Total: %.2f\n", total);
    }

    /**
     * Shows vehicles older than N years.
     * Prompts user for current year and N, then filters vehicles.
     */
    private void showOlderThanN() {
        try {
            System.out.println("\n=== Vehicles Older Than N Years ===");
            System.out.print("Enter current year: ");
            int currentYear = Integer.parseInt(scanner.nextLine().trim());
            
            System.out.print("Enter N (minimum age in years): ");
            int n = Integer.parseInt(scanner.nextLine().trim());
            
            if (n < 0) {
                System.out.println("N must be non-negative.");
                return;
            }
            
            List<Vehicle> olderVehicles = new ArrayList<>();
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getAge(currentYear) > n) {
                    olderVehicles.add(vehicle);
                }
            }
            
            if (olderVehicles.isEmpty()) {
                System.out.println("No vehicles older than " + n + " years found.");
            } else {
                System.out.println("\nVehicles older than " + n + " years:");
                for (Vehicle vehicle : olderVehicles) {
                    int age = vehicle.getAge(currentYear);
                    System.out.println(vehicle + " (Age: " + age + " years)");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please try again.");
        }
    }

    /**
     * Performs service for all vehicles in the fleet.
     * Demonstrates polymorphism through performService().
     */
    private void performAllService() {
        if (vehicles.isEmpty()) {
            System.out.println("\nNo vehicles in the fleet to service.");
            return;
        }
        
        System.out.println("\n=== Performing Service for All Vehicles ===");
        for (Vehicle vehicle : vehicles) {
            // Polymorphic call - the correct implementation is chosen at runtime
            vehicle.performService();
        }
        System.out.println("Service completed for all vehicles.");
        
        // Demonstrate polymorphic reference as required by the assignment
        if (!vehicles.isEmpty()) {
            System.out.println("\n=== Service Intervals ===");
            for (Vehicle vehicle : vehicles) {
                Servicable servicable = vehicle; // Polymorphic reference
                System.out.println("Vehicle ID " + vehicle.getId() + 
                        " service interval: " + servicable.getServiceIntervalKm() + " km");
            }
        }
    }
}
