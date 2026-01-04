/**
 * Concrete class representing a Bus.
 * Extends Vehicle and implements specific behavior for buses.
 */
public class Bus extends Vehicle {
    private int passengerCapacity;

    /**
     * Constructor for Bus.
     * @param model the model of the bus
     * @param year the manufacturing year
     * @param basePrice the base price
     * @param passengerCapacity the passenger capacity (must be positive)
     */
    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        setPassengerCapacity(passengerCapacity);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity <= 0) {
            throw new IllegalArgumentException("Passenger capacity must be positive");
        }
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * Calculates insurance fee for a bus.
     * Formula: 8% of base price
     * @return the insurance fee
     */
    @Override
    public double calculateInsuranceFee() {
        return getBasePrice() * 0.08;
    }

    @Override
    public void performService() {
        System.out.println("Bus " + getModel() + " (ID: " + getId() + 
                "): Performing full technical inspection");
    }

    @Override
    public int getServiceIntervalKm() {
        return 20000;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Bus, Passenger Capacity: " + passengerCapacity;
    }
}

