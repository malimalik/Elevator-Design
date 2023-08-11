import java.util.List; // Or Priority Queue based on your preference

public abstract class Elevator {
    protected int currentFloor;
    protected State state;
    protected boolean emergencyStatus = false;

    public Elevator(int currentFloor, boolean emergencyStatus) {
        this.currentFloor = currentFloor;
        this.state = State.IDLE;
        this.emergencyStatus = emergencyStatus;
    }

    protected abstract void moveToFloor(int floorNumber);


    public abstract void addRequestToQueue(Request request);

    // Empty the queue for both going up and down and go to the recall floor, which is mist likely the ground floor.
    public abstract void processEmergency();

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public State getState() {
        return state;
    }

    protected abstract void warnElevatorOverload();

}
