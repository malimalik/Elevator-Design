public class ServiceRequest extends Request {


//    private int weight;

    public ServiceRequest(RequestOrigin origin, int currentFloor, int destinationFloor) {
        super(origin, currentFloor, destinationFloor);
//        this.weight = (int) (Math.random() * 201);
        this.elevatorType = ElevatorType.SERVICE;

    }


    public ServiceRequest(RequestOrigin origin, int destinationFloor) {
        super(origin, destinationFloor);
//        this.weight = (int) (Math.random() * 201);
        this.elevatorType = ElevatorType.SERVICE;

    }

//    public int getWeight() {
//        return weight;
//    }

}
