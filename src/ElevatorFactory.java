public class ElevatorFactory {


    public Elevator createElevator(ElevatorType type) {
        return switch (type) {
            case PASSENGER -> new PassengerElevator(1, false); // Default values for the example
            case SERVICE -> new ServiceElevator(1, false); // Default values for the example
            default -> throw new IllegalArgumentException("Unknown criteria.");
        };
    }
}
