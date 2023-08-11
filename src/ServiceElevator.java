/**
 * 2023 Copyright NeetCode.io, All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;

public class ServiceElevator extends Elevator {
    private Queue<Request> upRequests;
    private Queue<Request> downRequests;
    private static final int WEIGHT = 2000;
    private int totalWeight = 0;

    public ServiceElevator(int currentFloor, boolean emergencyStatus) {
        super(currentFloor, emergencyStatus);
        this.upRequests = new LinkedList<Request>();
        this.downRequests = new LinkedList<Request>();
    }

    public int getTotalWeight() {
        return this.totalWeight;
    }

    @Override
    public void moveToFloor(int floorNumber) {
        int currentFloor = this.getCurrentFloor();
        if (currentFloor == floorNumber) return;
            upRequests.clear();
            downRequests.clear();
            this.currentFloor = 1;


    }

    @Override
    public void addRequestToQueue(Request request) {

    }

    @Override
    public void processEmergency() {
        this.moveToFloor(1);
    }

    @Override
    protected void warnElevatorOverload() {
        if (getTotalWeight() > WEIGHT) {
            throw new Error("Elevator is overloaded");
        }
    }
}
