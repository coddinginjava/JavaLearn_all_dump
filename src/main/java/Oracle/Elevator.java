package Oracle;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
    private int currentFloor;
    private String direction;
    private Queue<ExternalRequest> externalRequests;
    private Queue<InternalRequest> internalRequests;

    public Elevator() {
        this.currentFloor = 0;
        this.direction = null;
        this.externalRequests = new LinkedList<>();
        this.internalRequests = new LinkedList<>();
    }

    public void start() {
        System.out.println("Elevator started");
        while (!externalRequests.isEmpty() || !internalRequests.isEmpty()) {
            if (!internalRequests.isEmpty()) {
                processInternalRequest();
            } else if (!externalRequests.isEmpty()) {
                processExternalRequest();
            }
        }
        System.out.println("No more requests, elevator stopped");
    }

    public void addExternalRequest(ExternalRequest request) {
        externalRequests.add(request);
        System.out.println("External request added: Floor " + request.getFloor() + ", Direction " + request.getDirection());
    }

    public void addInternalRequest(InternalRequest request) {
        internalRequests.add(request);
        System.out.println("Internal request added: Floor " + request.getFloor());
    }

    private void processExternalRequest() {
        ExternalRequest request = externalRequests.poll();
        System.out.println("Processing external request: Floor " + request.getFloor() + ", Direction " + request.getDirection());
        moveToFloor(request.getFloor());
        this.direction = request.getDirection();
    }

    private void processInternalRequest() {
        InternalRequest request = internalRequests.poll();
        System.out.println("Processing internal request: Floor " + request.getFloor());
        moveToFloor(request.getFloor());
    }

    private void moveToFloor(int targetFloor) {
        while (currentFloor != targetFloor) {
            if (currentFloor < targetFloor) {
                currentFloor++;
            } else {
                currentFloor--;
            }
            System.out.println("Elevator at floor " + currentFloor);
            checkForNewRequests();
        }
    }

    private void checkForNewRequests() {
        for (ExternalRequest request : externalRequests) {
            if (request.getFloor() == currentFloor && request.getDirection().equals(this.direction)) {
                System.out.println("Stopping for new external request at floor " + request.getFloor());
                externalRequests.remove(request);
                addInternalRequest(new InternalRequest(request.getFloor()));  // Assume the person presses a floor button inside the elevator
                break;
            }
        }
    }
}
