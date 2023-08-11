public class Request {
    private RequestLocation location;
    private State direction;
    private int currentFloor;
    private int destinationFloor;
    private ElevatorType elevatorType;


    public Request(RequestLocation location, State direction, int currentFloor, int destinationFloor, ElevatorType elevatorType) {
        this.location = location;
        this.direction = direction;
        this.elevatorType = elevatorType;
        if (currentFloor > destinationFloor) {
            this.direction = State.GOING_DOWN;
        } else if (currentFloor < destinationFloor) {
            this.direction = State.GOING_UP;
        } else {
            throw new IllegalArgumentException("Destination floor must be different from the current floor");
        }

        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;

    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public int getDestinationFloor() {
        return this.destinationFloor;
    }

    public ElevatorType getRequestType() {
        return this.elevatorType;
    }


}
