import java.time.Instant;

public class Request {

    // where the request originated from: OUTSIDE, INSIDE
    private RequestLocation location;
    // is the elevator going up or down?
    private State direction;
    // what floor is the elevator on
    private int currentFloor;
    // what floor is the elevator going to
    private int destinationFloor;
    // is it a call to the service elevator or the passenger elevator
    protected ElevatorType elevatorType;

    protected Instant time;

    private final int CAPACITY = 1;

    public Request(RequestLocation location,
                   State direction,
                   int currentFloor,
                   int destinationFloor
                   ) {
        if (currentFloor > destinationFloor) {
            this.direction = State.GOING_DOWN;
        } else if (currentFloor < destinationFloor) {
            this.direction = State.GOING_UP;
        } else {
            throw new IllegalArgumentException("Destination floor can't be the same as the current floor.");
        }
        this.location = location;
        this.direction = direction;
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
        this.elevatorType = ElevatorType.PASSENGER;
        this.time = Instant.now();

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

    public RequestLocation getLocation() {
        return this.location;
    }

    public State getDirection() {
        return this.direction;
    }

    public ElevatorType getElevatorType() {
        return this.elevatorType;
    }

    public int getCAPACITY() {
        return this.CAPACITY;
    }

    public Instant getTime() {
        return this.time;
    }
}
