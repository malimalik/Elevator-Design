
public class Request {
    private RequestOrigin origin;
    private State direction = State.IDLE;
    private int originFloor;
    private int destinationFloor;
    protected ElevatorType elevatorType;
//    private int capacity;

    public Request(RequestOrigin origin,
                   int originFloor,
                   int destinationFloor
    ) {
        if (originFloor > destinationFloor) {
            this.direction = State.GOING_DOWN;
        } else if (originFloor < destinationFloor) {
            this.direction = State.GOING_UP;
        }
        this.origin = origin;
        this.originFloor = originFloor;
        this.destinationFloor = destinationFloor;
//        this.capacity = (int) (Math.random() * (5 - 1 + 1)) + 1;
        this.elevatorType = ElevatorType.PASSENGER;
    }

    public Request(RequestOrigin origin, int destinationFloor) {
        this.origin = origin;
        this.destinationFloor = destinationFloor;
    }

    public int getOriginFloor() {
        return this.originFloor;
    }

    public int getDestinationFloor() {
        return this.destinationFloor;
    }

    public RequestOrigin getOrigin() {
        return this.origin;
    }

    public State getDirection() {
        return this.direction;
    }

//    public int getCapacity() {
//        return this.capacity;
//    }


}
