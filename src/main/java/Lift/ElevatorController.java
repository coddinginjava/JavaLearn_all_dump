package Lift;

public class ElevatorController {
    public Elevator elevator;

    public ElevatorController() {
        elevator = new Elevator(0);
    }

    public void addExternalRequest(ExternalRequest request) {
        elevator.addExternalRequest(request);
    }

    public void step() {
        elevator.move();
    }

    @Override
    public String toString() {
        return elevator.toString();
    }
}
