import java.util.PriorityQueue;


public class PassengerElevator extends Elevator {

    private PriorityQueue<Request> passengerUpQueue;
    private PriorityQueue<Request> passengerDownQueue;
    private final int CAPACITY_LIMIT = 24;

    public PassengerElevator(int currentFloor,
                             boolean emergencyStatus) {
        super(currentFloor, emergencyStatus);
    }


    // depending on the direction and the location of the request, move it to the pertinent direction.
    @Override
    protected void moveToFloor() {

    }

    @Override
    public void processEmergency() {
        passengerUpQueue.clear();
        passengerDownQueue.clear();
    }


    // add it to the relevant queue, depending on the direction of the request
    //
    public void addRequestToQueue(Request request) {

        if (request.getDirection() == State.GOING_DOWN) {
                passengerDownQueue.offer(new Request(request));
        }
    }

    @Override
    public boolean isElevatorOverloaded() {
        return passengerUpQueue.size() + passengerDownQueue.size() > CAPACITY_LIMIT;
    }
}
