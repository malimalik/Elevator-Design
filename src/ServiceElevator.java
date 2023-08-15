/**
 * 2023 Copyright NeetCode.io, All rights reserved.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;

public class ServiceElevator extends Elevator {
    private LinkedList<ServiceRequest> serviceQueue;
    private static final int WEIGHT_LIMIT = 2000;

    // Here, our goal is to make sure that we keep accumulating the weight in every request that is sent
    // Perhaps we can do a Math.random() for every weight?

    public ServiceElevator(int currentFloor, boolean emergencyStatus) {
        super(currentFloor, emergencyStatus);
        this.serviceQueue = new LinkedList<>();
    }

    // handles the logic for prioritizing the requests and moving the requests
    // according to a first come first-serve basis.
    @Override
    public void moveToFloor() {

        while (!serviceQueue.isEmpty()) {
            ServiceRequest currRequest = serviceQueue.remove();
            try {
                if (isElevatorOverloaded()) {
                    throw new ElevatorOverloadedException("Elevator overloaded with weight: " + currRequest.getWeight());
                }

                // move the elevator to the destination floor
                this.setCurrentFloor(currRequest.getDestinationFloor());
                this.setState(currRequest.getDirection());
                System.out.println("Currently at " + this.currentFloor);

            } catch (ElevatorOverloadedException e) {
                System.err.println(e.getMessage()); // Prints the error message.
                continue;
            }
        }

        this.setState(State.IDLE);
    }


    /** This method will be the one to add the request to the relevant queue*/
    public void addRequestToQueue(ServiceRequest request) {
            serviceQueue.add(request);
    }


    /** Clears the queues of the requests and will move
     * the elevator the first floor, which is the home floor.*/
    @Override
    public void processEmergency() {
        serviceQueue.clear();
        this.setCurrentFloor(1);
        this.setState(State.IDLE);
    }


    public boolean isElevatorOverloaded(ServiceRequest request) {
        return request.getWeight() > WEIGHT_LIMIT;
    }

}
