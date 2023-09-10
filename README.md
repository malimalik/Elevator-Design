# Elevator-Design


## Context

This elevator system contains two elevators: A passenger elevator and a service elevator. The passenger elevator is
responsible picking up passengers and the service elevator is used for moving heavy objects like furniture or heavy
equipment, in case the building needs maintenance.


The following is how the algorithms for both of the elevators work:

## The passenger elevator

In the real world, passenger elevators prioritize direction over the proximity of requests. The following is a scenario that demonstrates the behavior of the passenger elevator. 

### Scenario:
The elevator starts in an IDLE state at floor 1.
A request is made from outside the elevator at floor 3 to go to floor 6.
While the elevator is on its way to floor 6, there's another request from floor 5 to go to floor 9.
Before reaching floor 9, a request is made from the outside of floor 7 to go to floor 1.


### Step-by-Step Walkthrough:
**1. Initial State:** The elevator is IDLE at floor 1.

 **2. First Up Request:**

A passenger on floor 3 presses the up button, signaling they want to go to floor 6.
The pick-up request for floor 3 is added to the passengerUpQueue.
The destination request for floor 6 (from floor 3) is also added to the passengerUpQueue.
Processing Begins:

The elevator starts moving upwards to address the pick-up request at floor 3.


**3. Intermediate Up Request:**

While the elevator is en route to floor 6, when it reaches floor 5, it detects another passenger wanting to travel upwards to floor 9.
The elevator stops at floor 5 to pick up this passenger.
The destination request for floor 9 (from floor 5) is added to the passengerUpQueue.

**4. Continuing Upwards:**

The elevator first heads to floor 6 to drop off the passenger from floor 3.
After this, it proceeds to floor 9 to drop off the passenger from floor 5.

**5. Downward Request Ignored:**
On the way to floor 9, when the elevator passes floor 7, it detects a passenger wanting to travel downwards to floor 1.
Since the elevator is currently processing all upward requests and is in a GOING_UP state, this request is not immediately catered to and is added to the passengerDownQueue.


**6. Switching Directions:**

After dropping off the passenger at floor 9, the elevator checks if there are any GOING_DOWN requests in the passengerDownQueue.
It detects the request from floor 7 and starts heading there.

**7. Handling Down Request:**

The elevator stops at floor 7, picks up the passenger, and then proceeds downwards to floor 1 as per the passenger's request.

**8. Completion:**

Having catered to all pending requests, the elevator ends its operations for the time being and remains IDLE at floor 1, awaiting further requests.


## The Service Elevator

### Scenario:
The elevator starts in an IDLE state at floor 1.
A request is made from outside the elevator at floor 3 to go to floor 6.
While the elevator is on its way to floor 6, there's another request from floor 5 to go to floor 9.
Before reaching floor 9, a request is made from the outside of floor 7 to go to floor 1.

### Step-by-Step Walkthrough:

**1. Initial State:** The elevator is IDLE at floor 1.

**2. First Up Request:**

A passenger on floor 3 presses the up button, wanting to go to floor 6.
The request is added to the serviceElevatorQueue.

**3. Processing Begins:**

The elevator starts moving upwards to address the request at floor 3.
**4. Intermediate Up Request:**

Just as the elevator is about to reach floor 3, the request from floor 5 arrives. It's added to the serviceElevatorQueue behind the initial request.
The elevator stops at floor 3, picks up the passenger, and is now headed for floor 6 to drop them off.

**5. Second Up Request:**

On its way to floor 6, when the elevator is about to reach floor 5, it does not stop for the passenger there, as the floor 3 to 6 request is being served first (FCFS).
The elevator continues to floor 6 to drop off the passenger from floor 3.

**6. Third Request:**

On its way to floor 6, the elevator detects a request from floor 7 wanting to go to floor 1.
This request is added to the serviceElevatorQueue at the end.

**7. Heading to Floor 5:**

After dropping off the passenger at floor 6, the elevator now heads back to floor 5 to pick up the passenger wanting to go to floor 9 since that was the second request in line.

**8. Heading to Floor 9:**

The elevator picks up the passenger from floor 5 and moves toward floor 9.
It drops off the passenger at floor 9 as per their request.

**9. Handling Floor 7 Request:**

Now, the elevator moves to floor 7 to address the last request in the queue.
It stops at floor 7, picks up the passenger, and then starts moving downwards to floor 1 as requested.

**10. Completion:**

The elevator drops off the passenger from floor 7 at floor 1.
With all requests from the queue processed, the elevator is now IDLE at floor 1, awaiting more requests.
In the FCFS approach, the service elevator processes requests strictly based on the order they come in. While this might seem inefficient when observing the elevator move up and down frequently, it ensures that no one has to wait longer than necessary based on their request time.


To run, please ensure the following:

1. You have at least Java 14 installed.
2. You run the `Main.java` file and open your console to see output, which should look like the following.


```markdown
Currently on floor 1. No movement as destination is the same.
The current floor is 1. Next stop: 3
Moving ...
Arrived at 3
Doors are OPEN on floor 3
Doors are CLOSED
The current floor is 3. Next stop: 5
Moving ...
Arrived at 5
Doors are OPEN on floor 5
Doors are CLOSED
The current floor is 5. Next stop: 6
Moving ...
Arrived at 6
Doors are OPEN on floor 6
Doors are CLOSED
Finished processing all the up requests.
Now processing down requests...
The current floor is 6. Next stop: 4
Moving ...
Arrived at 4
Doors are OPEN on floor 4
Doors are CLOSED
The current floor is 4. Next stop: 2
Moving ...
Arrived at 2
Doors are OPEN on floor 2
Doors are CLOSED
Finished processing all the down requests.
All requests have been fulfilled, elevator is now IDLE
Now processing service requests

Currently at 1
IDLE...Arrived at 13
Doors are OPEN on floor 13
Doors are CLOSED

Currently at 13
GOING_DOWN...Arrived at 2
Doors are OPEN on floor 2
Doors are CLOSED

Currently at 2
GOING_UP...Arrived at 15
Doors are OPEN on floor 15
Doors are CLOSED
All requests have been fulfilled, elevator is now IDLE

```
