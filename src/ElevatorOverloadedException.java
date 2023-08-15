public class ElevatorOverloadedException extends Exception {
    public ElevatorOverloadedException() {
        super("The elevator is overloaded!");
    }

    public ElevatorOverloadedException(String message) {
        super(message);
    }
}
