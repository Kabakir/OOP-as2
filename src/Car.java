import java.time.Year;

/**
 * Concrete class representing a Car.
 * Extends Vehicle and implements specific behavior for cars.
 */
public class Car extends Vehicle {
    private int numberOfDoors;

    /**
     * Constructor for Car.
     * @param model the model of the car
     * @param year the manufacturing year
     * @param basePrice the base price
     * @param numberOfDoors the number of doors (must be positive)
     */
    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        setNumberOfDoors(numberOfDoors);
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors <= 0) {
            throw new IllegalArgumentException("Number of doors must be positive");
        }
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Calculates insurance fee for a car.
     * Formula: 5% of base price + 10 * age in years
     * @return the insurance fee
     */
    @Override
    public double calculateInsuranceFee() {
        int age = getAge(Year.now().getValue());
        return getBasePrice() * 0.05 + age * 10;
    }

    @Override
    public void performService() {
        System.out.println("Car " + getModel() + " (ID: " + getId() + 
                "): Performing oil change and tire check");
    }

    @Override
    public int getServiceIntervalKm() {
        return 10000;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Car, Number of Doors: " + numberOfDoors;
    }
}

