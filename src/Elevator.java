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
    protected void setState(State state) {
        this.state = state;
    }
    protected void setCurrentFloor(int floor) {
        this.currentFloor = floor;
    }
    protected void setEmergencyStatus() {
        this.emergencyStatus = true;
    }
}
