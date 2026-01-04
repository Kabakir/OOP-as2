# OOP Assignment 2 - Fleet Management System

## Course Information
- **Course**: Object Oriented Programming (Java)
- **Instructor**: Traxel Xeniya Alexandrovna
- **Trimester/Year**: 2/1
- **Assignment**: Data Abstraction (Inheritance and Polymorphism)

## Project Description

This project implements a Fleet Management System that demonstrates key OOP concepts including:
- Abstract classes and inheritance
- Interface implementation
- Polymorphism
- Encapsulation

## Project Structure

```
src/
├── Servicable.java      # Interface for serviceable objects
├── Vehicle.java         # Abstract base class for vehicles
├── Car.java            # Concrete class representing a car
├── Bus.java            # Concrete class representing a bus
└── FleetApp.java       # Main console application
```

## Features

### Task 1: Abstract Class Vehicle and Subclasses (10 points)
- ✅ Abstract class `Vehicle` with protected/private fields
- ✅ Static ID generator (`idGen`)
- ✅ Constructors with validation
- ✅ Getters and setters with validation
- ✅ `getAge()` method
- ✅ Abstract `calculateInsuranceFee()` method
- ✅ `toString()` override
- ✅ Two concrete subclasses: `Car` and `Bus`
- ✅ Different insurance fee calculations for Car and Bus

### Task 2: Interfaces and Polymorphic Behavior (20 points)
- ✅ `Servicable` interface with `performService()` and `getServiceIntervalKm()`
- ✅ `Vehicle` implements `Servicable`
- ✅ Different implementations in `Car` and `Bus`
- ✅ Different service intervals (Car: 10,000 km, Bus: 20,000 km)
- ✅ Polymorphic references demonstrated in `FleetApp`

### Task 3: Console Application FleetApp (30 points)
- ✅ Menu-driven console application
- ✅ ArrayList<Vehicle> for fleet management
- ✅ All required functionality:
  - Print all vehicles
  - Add new car
  - Add new bus
  - Show total yearly insurance fees
  - Show vehicles older than N years
  - Perform service for all vehicles
  - Quit
- ✅ Input validation and error handling
- ✅ Polymorphism demonstrated in multiple places

## How to Compile and Run

### Prerequisites
- Java JDK 8 or higher

### Compilation
```bash
cd src
javac *.java
```

### Execution
```bash
java FleetApp
```

## Design Decisions

### Why Vehicle implements Servicable?
The `Vehicle` class implements `Servicable` because:
- All vehicles in our system can be serviced
- This design allows for a common interface across all vehicle types
- It simplifies the code in `FleetApp` where we can treat all vehicles as `Servicable`
- Future vehicle types will automatically inherit the service capability

### Inheritance Hierarchy
```
Servicable (interface)
    ↑
Vehicle (abstract class)
    ↑
    ├── Car (concrete class)
    └── Bus (concrete class)
```

### Polymorphism Examples
1. **Insurance Fee Calculation**: `vehicle.calculateInsuranceFee()` - each subclass has its own implementation
2. **Service Performance**: `vehicle.performService()` - different messages for Car vs Bus
3. **Service Intervals**: `servicable.getServiceIntervalKm()` - different intervals for different vehicle types

## Validation Rules

- **Model**: Cannot be null or empty
- **Year**: Must be between 1886 (first car) and current year
- **Base Price**: Must be greater than 0
- **Number of Doors**: Must be positive (for Car)
- **Passenger Capacity**: Must be positive (for Bus)

## Insurance Fee Formulas

- **Car**: `basePrice * 0.05 + age * 10`
- **Bus**: `basePrice * 0.08`

## Service Intervals

- **Car**: 10,000 km
- **Bus**: 20,000 km

## Author

Student submission for OOP Assignment 2

## License

This is an academic assignment submission.

