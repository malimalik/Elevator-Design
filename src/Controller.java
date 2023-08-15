import java.util.PriorityQueue;
import java.util.LinkedList;

public class Controller {

    // Attributes
    private Elevator passengerElevator;
    private Elevator serviceElevator;

    private static final int CAPACITY_LIMIT = 24;
    private static final int WEIGHT_LIMIT = 2000;


    // Constructor
    public Controller(PassengerElevator passengerElevator, ServiceElevator serviceElevator) {
     this.passengerElevator = new PassengerElevator(1, false);
     this.serviceElevator = new ServiceElevator(1, false);
    }

    // Methods
    public void sendPassengerRequest(Request request) {

    }

    public void sendServiceRequest(Request request) {

    }

    public void handlePassengerRequests() {



    }

    public void handleServiceRequests() {

    }

    /** Empties all the queues of all the requests and takes the elevator
     * to first floor. */
    public void handleEmergency() {
    }

    public static void main(String[] args) {

    }
}
