import java.util.PriorityQueue;
import java.util.LinkedList;

public class Controller {

    // Attributes
    private ElevatorFactory factory;
    private PassengerElevator passengerElevator;
    private ServiceElevator serviceElevator;
    // Constructor
    public Controller(ElevatorFactory factory) {
        this.factory = factory;
        this.passengerElevator = factory.createElevator(ElevatorType.PASSENGER);
        this.serviceElevator = factory.createElevator(ElevatorType.SERVICE);
    }

    // Methods
    public void sendPassengerRequest(Request request) {
        this.passengerElevator.add
    }

    public void sendServiceRequest(Request request) {
            this.serviceElevator.addRequestToQueue(request);
    }

    public void handlePassengerRequests() {
        this.passengerElevator.moveToFloor();


    }

    public void handleServiceRequests() {
        this.serviceElevator.moveToFloor();
    }

    public void handleEmergency() {
        passengerElevator.processEmergency();
        serviceElevator.processEmergency();
    }


}
