/**
 * Interface for objects that can be serviced.
 * Defines methods for performing service and getting service intervals.
 */
public interface Servicable {
    /**
     * Performs service on the object.
     */
    void performService();

    /**
     * Returns the service interval in kilometers.
     * @return service interval in kilometers
     */
    int getServiceIntervalKm();
}

