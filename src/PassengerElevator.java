import java.util.PriorityQueue;


public class PassengerElevator extends Elevator {

    private PriorityQueue<Request> passengerUpQueue;
    private PriorityQueue<Request> passengerDownQueue;
    private int currentCapacity;

    private final int CAPACITY = 24;

    public PassengerElevator(int currentFloor,
                             boolean emergencyStatus) {
        super(currentFloor, emergencyStatus);
    }

    @Override
    protected void moveToFloor() {

    }

    @Override
    public void addRequestToQueue(Request request) {
        System.out.println(request + " was added to the queue");
    }

    @Override
    public void processEmergency() {
        passengerUpQueue.clear();
        passengerDownQueue.clear();
    }

    @Override
    protected boolean warnElevatorOverload() {
        return passengerUpQueue.size() + passengerDownQueue.size() > currentCapacity;
    }
}
