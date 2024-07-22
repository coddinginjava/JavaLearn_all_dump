package Oracle;

public class Main {

    /*
    *
0 -> 5
2 -> 7
3 <- 0

    *
    * */

    public static void main(String[] args) {
        ElevatorController ev = new ElevatorController();


        ev.handleInternalRequest(5);

        ev.handleExternalRequest(5, "up");

        ev.handleExternalRequest(7, "down");

        ev.startElevator();

    }
}
