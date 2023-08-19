import java.util.PriorityQueue;


public class PassengerElevator extends Elevator {

    private PriorityQueue<Request> passengerUpQueue;
    private PriorityQueue<Request> passengerDownQueue;
    private final int CAPACITY_LIMIT = 24;


    public PassengerElevator(int currentFloor,
                             boolean emergencyStatus) {
        super(currentFloor, emergencyStatus);
        passengerUpQueue = new PriorityQueue<>((a, b) -> a.getDestinationFloor() - b.getDestinationFloor());
        passengerDownQueue = new PriorityQueue<>((a, b) -> b.getDestinationFloor() - a.getDestinationFloor());

    }

    @Override
    protected void operate() {
        while (!passengerUpQueue.isEmpty() || !passengerDownQueue.isEmpty()) {
            processRequests();
        }
        this.setState(State.IDLE);
        System.out.println("All requests have been fulfilled, elevator is now " + this.getState());
    }


    @Override
    public void processEmergency() {
        passengerUpQueue.clear();
        passengerDownQueue.clear();

        this.setCurrentFloor(1);
        this.setState(State.IDLE);
        this.openDoors();
        this.setEmergencyStatus(true);
        System.out.println("Queues cleared, current floor is " + this.getCurrentFloor() + ". Doors are " + this.getDoorState());
    }


    public void addUpRequest(Request request) {
        if (request.getOrigin() == RequestOrigin.OUTSIDE) {
            Request pickUpRequest = new Request(request.getOrigin(), request.getOriginFloor(), request.getOriginFloor());
            passengerUpQueue.offer(pickUpRequest);
        }
        passengerUpQueue.offer(request);
    }


    public void addDownRequest(Request request) {
        // if the request is made from the outside
        if (request.getOrigin() == RequestOrigin.OUTSIDE) {
            Request pickUpRequest = new Request(request.getOrigin(), request.getOriginFloor(), request.getOriginFloor());
            passengerDownQueue.offer(pickUpRequest);
        }
        passengerDownQueue.offer(request);
    }


    private void processUpRequests() {
        while (!passengerUpQueue.isEmpty()) {
            Request upRequest = passengerUpQueue.poll();


            if (this.getCurrentFloor() == upRequest.getDestinationFloor()) {
                System.out.println("Currently on floor " + this.getCurrentFloor() + ". No movement as destination is the same.");
                continue;
            }
            System.out.println("The current floor is " + this.getCurrentFloor() + ". Next stop: " + upRequest.getDestinationFloor());

            try {
                System.out.print("Moving ");
                for (int i = 0; i < 3; i++) {
                    System.out.print(".");
                    Thread.sleep(500); // Pause for half a second between dots.
                }
                Thread.sleep(1000); // Assuming 1 second to move to the next floor.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.setCurrentFloor(upRequest.getDestinationFloor());
            System.out.println("\nArrived at " + this.getCurrentFloor());

            openDoors();
            waitForSeconds(3); // Simulating 3 seconds for people to enter/exit.
            closeDoors();
        }
        System.out.println("Finished processing all the up requests.");
    }

    private void processDownRequests() {
        while (!passengerDownQueue.isEmpty()) {
            Request downRequest = passengerDownQueue.poll();

            if (this.getCurrentFloor() == downRequest.getDestinationFloor()) {
                System.out.println("Currently on floor " + this.getCurrentFloor() + ". No movement as destination is the same.");
                continue;
            }

            System.out.println("The current floor is " + this.getCurrentFloor() + ". Next stop: " + downRequest.getDestinationFloor());

            try {
                System.out.print("Moving ");
                for (int i = 0; i < 3; i++) {
                    System.out.print(".");
                    Thread.sleep(500); // Pause for half a second between dots.
                }
                Thread.sleep(1000); // Assuming 1 second to move to the next floor.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.setCurrentFloor(downRequest.getDestinationFloor());
            System.out.println("\nArrived at " + this.getCurrentFloor());

            openDoors();
            waitForSeconds(3); // Simulating 3 seconds for people to enter/exit.
            closeDoors();
        }
        System.out.println("Finished processing all the down requests.");
    }

    public void processRequests() {
        if (this.getState() == State.GOING_UP || this.getState() == State.IDLE) {
            processUpRequests();
            if (!passengerDownQueue.isEmpty()) {
                System.out.println("Now processing down requests...");
                processDownRequests();
            }
        } else {
            processDownRequests();
            if (!passengerUpQueue.isEmpty()) {
                System.out.println("Now processing up requests...");
                processUpRequests();
            }
        }
    }


}
