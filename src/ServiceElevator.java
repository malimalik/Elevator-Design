/**
 * 2023 Copyright NeetCode.io, All rights reserved.
 */

import java.util.LinkedList;
import java.util.Queue;

public class ServiceElevator extends Elevator {
    private Queue<Request> upRequests;
    private Queue<Request> downRequests;
    private static final int CAPACITY = 24;
    private static final int WEIGHT = 2000;

    public ServiceElevator(int currentFloor, boolean emergencyStatus) {
        super(currentFloor, emergencyStatus);
        this.upRequests = new LinkedList<Request>();
        this.downRequests = new LinkedList<Request>();
    }

    @Override
    public void moveToFloor(int floorNumber) {
        int currentFloor = this.getCurrentFloor();
        if (currentFloor == floorNumber) return;
            upRequests.clear();
            downRequests.clear();


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
        System.out.println("Warning, Warning!");
    }
}
