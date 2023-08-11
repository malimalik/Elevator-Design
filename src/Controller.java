import java.util.PriorityQueue;
import java.util.LinkedList;

public class Controller {

    // Attributes
    private PassengerElevator passengerElevator;
    private ServiceElevator serviceElevator;

    private PriorityQueue<Request> passengerUpQueue;
    private PriorityQueue<Request> passengerDownQueue;
    private LinkedList<Request> serviceUpQueue;
    private LinkedList<Request> serviceDownQueue;


    private static final int CAPACITY = 24;

    // Constructor
    public Controller() {

    }

    // Methods
    public void sendPassengerRequest(Request request) throws ElevatorCapacityException {

    }

    public void sendServiceRequest(Request request) throws ElevatorCapacityException {

    }

    public void handlePassengerRequests() {

    }

    public void handleServiceRequests() {

    }

    /** Empties all the queues of all the requests and takes the elevator
     * to first floor. */
    public void handleEmergency() {
        passengerUpQueue.clear();
        passengerDownQueue.clear();
        serviceUpQueue.clear();
        serviceDownQueue.clear();


    }


    public static void main(String[] args) {
        Elevator el = new ServiceElevator(1, false);
        el.warnElevatorOverload();
    }
}
