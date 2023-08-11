import java.util.PriorityQueue;
import java.util.LinkedList;

public class Controller {

    // Attributes
    private PassengerElevator passengerElevator;
    private ServiceElevator serviceElevator;

    private PriorityQueue<Request> passengerUpQueue;
    private PriorityQueue<Request> passengerDownQueue;
    private LinkedList<Request> serviceQueue;

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

    public void handleEmergency() {

    }


    public static void main(String[] args) {
        Elevator el = new ServiceElevator(1, false);
        el.warnElevatorOverload();
    }
}
