package Oracle;

public abstract class Request {
    private int floor;

    public Request(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }
}
