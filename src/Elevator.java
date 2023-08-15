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

    protected abstract void moveToFloor();
    public abstract void processEmergency();
    public int getCurrentFloor() {
        return this.currentFloor;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }


}
