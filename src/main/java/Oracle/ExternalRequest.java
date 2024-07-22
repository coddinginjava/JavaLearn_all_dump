package Oracle;

public class ExternalRequest extends Request {
    private String direction;

    public ExternalRequest(int floor, String direction) {
        super(floor);
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
