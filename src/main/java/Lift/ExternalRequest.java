package Lift;
public class ExternalRequest {
    private int floor;
    private Direction direction;

    public ExternalRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "ExternalRequest{" +
                "floor=" + floor +
                ", direction=" + direction +
                '}';
    }
}