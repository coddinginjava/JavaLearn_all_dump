package Lift;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Elevator {
    private int currentFloor;
    private Direction direction;
    private List<Integer> internalRequests;
    private List<ExternalRequest> externalRequests;

    public Elevator(int currentFloor) {
        this.currentFloor = currentFloor;
        this.direction = Direction.IDLE;
        this.internalRequests = new ArrayList<>();
        this.externalRequests = new ArrayList<>();
    }

    public void addInternalRequest(int floor) {
        if (!internalRequests.contains(floor)) {
            internalRequests.add(floor);
            Collections.sort(internalRequests);
        }

    }

    public void addExternalRequest(ExternalRequest request) {
        externalRequests.add(request);
        processRequests();
    }

    public void move() {
        if (direction == Direction.UP) {
            currentFloor++;
        } else if (direction == Direction.DOWN) {
            currentFloor--;
        }
        processRequests();
    }

    public void processRequests() {
        if (internalRequests.isEmpty() && externalRequests.isEmpty()) {
            direction = Direction.IDLE;
            return;
        }

        if (!internalRequests.isEmpty()) {
            int destination = internalRequests.get(0);
            if (currentFloor < destination) {
                direction = Direction.UP;
            } else if (currentFloor > destination) {
                direction = Direction.DOWN;
            } else {
                internalRequests.remove(0);
                processRequests();
            }
        } else if (!externalRequests.isEmpty()) {
            ExternalRequest request = externalRequests.get(0);
            if (currentFloor < request.getFloor()) {
                direction = Direction.UP;
            } else if (currentFloor > request.getFloor()) {
                direction = Direction.DOWN;
            } else {
                externalRequests.remove(0);
                direction = request.getDirection();
                processRequests();
            }
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "currentFloor=" + currentFloor +
                ", direction=" + direction +
                ", internalRequests=" + internalRequests +
                ", externalRequests=" + externalRequests +
                '}';
    }
}
