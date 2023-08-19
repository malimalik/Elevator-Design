public class Main {

    public static void main(String[] args) {
        ElevatorFactory factory = new ElevatorFactory();
        Controller controller = new Controller(factory);


        controller.sendPassengerUpRequests(new Request(RequestOrigin.OUTSIDE, 1, 5));
        controller.sendPassengerDownRequests(new Request(RequestOrigin.OUTSIDE, 4, 2));
        controller.sendPassengerUpRequests(new Request(RequestOrigin.OUTSIDE, 3, 6));
        controller.handlePassengerRequests();

//        controller.sendPassengerUpRequests(new Request(RequestOrigin.OUTSIDE, 1, 9));
//        controller.sendPassengerDownRequests(new Request(RequestOrigin.INSIDE, 5));
//        controller.sendPassengerUpRequests(new Request(RequestOrigin.OUTSIDE, 4, 12));
//        controller.sendPassengerDownRequests(new Request(RequestOrigin.OUTSIDE, 10, 2));
//        controller.handlePassengerRequests();


//        controller.sendPassengerUpRequests(new Request(RequestOrigin.OUTSIDE, 1, 9));
//        controller.sendPassengerDownRequests(new Request(RequestOrigin.INSIDE, 11, 5));
//        controller.sendPassengerUpRequests(new Request(RequestOrigin.OUTSIDE, 4, 12));
//        controller.sendPassengerDownRequests(new Request(RequestOrigin.OUTSIDE, 10, 2));
//        controller.handlePassengerRequests();
//
//
//        controller.sendPassengerUpRequests(new Request(RequestOrigin.OUTSIDE, 5, 11));
//        controller.sendPassengerDownRequests(new Request(RequestOrigin.OUTSIDE, 5, 2));
//        controller.sendPassengerUpRequests(new Request(RequestOrigin.OUTSIDE, 5, 10));
//        controller.handlePassengerRequests();
//
//
//        controller.sendPassengerUpRequests(new Request(RequestOrigin.OUTSIDE, 3, 3));
//        controller.sendPassengerDownRequests(new Request(RequestOrigin.INSIDE, 6, 6));
//        controller.handlePassengerRequests();


        controller.sendServiceRequest(new ServiceRequest(RequestOrigin.INSIDE, 13));
        controller.sendServiceRequest(new ServiceRequest(RequestOrigin.OUTSIDE, 13, 2));
        controller.sendServiceRequest(new ServiceRequest(RequestOrigin.INSIDE, 13, 15));


        System.out.println("Now processing service requests");

        controller.handleServiceRequests();
    }
}
