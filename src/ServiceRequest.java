public class ServiceRequest extends Request {



    // every request will have a weight associated with it. THe weight will be between 0 and 200 KG. This is what we are assuming.
    private int weight;
    public ServiceRequest(RequestLocation location,
                            State direction,
                            int currentFloor, int destinationFloor) {
        super(location, direction, currentFloor, destinationFloor);
        this.weight = (int) (Math.random() * 201);
        this.elevatorType = ElevatorType.SERVICE;

    }

    public int getWeight() {
        return weight;
    }
}
