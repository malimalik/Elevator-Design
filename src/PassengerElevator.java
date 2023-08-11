import java.util.PriorityQueue;


public class PassengerElevator extends Elevator {


    private PriorityQueue<Request> upRequests;
    private PriorityQueue<Request> downRequests;
    private static final int CAPACITY = 24;

    public PassengerElevator(int currentFloor,
                             boolean emergencyStatus) {
            super(currentFloor, emergencyStatus);
            this.upRequests = new PriorityQueue<>((r1, r2) -> r1.getDestinationFloor() - r2.getDestinationFloor());
            this.downRequests = new PriorityQueue<>((r1, r2) -> r2.getDestinationFloor() - r1.getDestinationFloor());
    }

    @Override
    protected void moveToFloor(int floorNumber) {

    }

    @Override
    public void addRequestToQueue(Request request) {
        System.out.println(request + " was added to the queue");
    }

    @Override
    public void processEmergency() {
        this.moveToFloor(1);
    }

    @Override
    protected void warnElevatorOverload() {
        if (upRequests.size() + downRequests.size() > CAPACITY) {
            throw new Error("Elevator capacity reached");
        }
    }
}
