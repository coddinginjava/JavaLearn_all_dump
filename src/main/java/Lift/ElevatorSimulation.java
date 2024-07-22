package Lift;

public class ElevatorSimulation {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController();

        ExternalRequest request1 = new ExternalRequest(0, Direction.UP);
        controller.addExternalRequest(request1);

        for (int i = 0; i < 10; i++) {
            System.out.println(controller);
            controller.step();
            if (i == 1) {
                controller.elevator.addInternalRequest(5);
            }
            if (i == 3) {
                ExternalRequest request2 = new ExternalRequest(2, Direction.UP);
                controller.addExternalRequest(request2);
            }
            if (i == 5) {
                ExternalRequest request3 = new ExternalRequest(2, Direction.DOWN);
                controller.addExternalRequest(request3);
            }
        }
    }
}
