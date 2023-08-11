public class ServiceRequest extends Request {

    public ServiceRequest(RequestLocation location,
                            State direction,
                            int currentFloor, int destinationFloor,
                            ElevatorType elevatorType) {
        super(location, direction, currentFloor, destinationFloor);
        this.elevatorType = ElevatorType.SERVICE;

    }
}
