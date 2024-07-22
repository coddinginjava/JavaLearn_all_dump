package Oracle;

public class ElevatorController {
    private Elevator elevator = new Elevator();

    public void handleExternalRequest(int floor, String direction) {
        ExternalRequest request = new ExternalRequest(floor, direction);
        elevator.addExternalRequest(request);
    }

    public void handleInternalRequest(int floor) {
        InternalRequest request = new InternalRequest(floor);
        elevator.addInternalRequest(request);
    }

    public void startElevator() {
        elevator.start();
    }

}
