import java.time.Year;

/**
 * Abstract class representing a generic vehicle.
 * Implements Servicable interface and provides common functionality for all vehicles.
 */
public abstract class Vehicle implements Servicable {
    private int id;
    private static int idGen = 1;
    private String model;
    private int year;
    private double basePrice;

    /**
     * Constructor for Vehicle.
     * @param model the model of the vehicle (must not be null or empty)
     * @param year the manufacturing year (must be in reasonable range)
     * @param basePrice the base price (must be > 0)
     */
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
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty");
        }
        this.model = model.trim();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1886 || year > currentYear) {
            throw new IllegalArgumentException("Year must be between 1886 and " + currentYear);
        }
        this.year = year;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be greater than 0");
        }
        this.basePrice = basePrice;
    }

    /**
     * Calculates the age of the vehicle.
     * @param currentYear the current year
     * @return the age of the vehicle in years
     */
    public int getAge(int currentYear) {
        return currentYear - year;
    }

    /**
     * Abstract method to calculate insurance fee.
     * Must be implemented by subclasses.
     * @return the insurance fee
     */
    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return String.format("ID: %d, Model: %s, Year: %d, Base Price: %.2f",
                id, model, year, basePrice);
    }
}

