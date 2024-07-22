package Oracle;

public class InternalRequest {
    private int floor;

    public InternalRequest(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "InternalRequest{" +
                "floor=" + floor +
                '}';
    }
}