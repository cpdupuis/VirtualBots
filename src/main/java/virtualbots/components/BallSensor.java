package virtualbots.components;

public class BallSensor {
    private Double nearestBallDirection = null;
    private Double nearestBallDistance = null;

     // Returns negative if bot should turn left or positive to turn right. Values range from -Pi to +Pi
    // Returns null if there are no balls
    public Double getBallDirection() {
        return nearestBallDirection;
    }

    public Double getBallDistance() {
        return nearestBallDistance;
    }

    // This is used by the simulation to populate the direction to the ball.
    public void setBallDirection(Double nearestBallDirection) {
        this.nearestBallDirection = nearestBallDirection;
    }

    // This is used by the simulation to populate the distance to the ball
    public void setBallDistance(Double nearestBallDistance) {
        this.nearestBallDistance = nearestBallDistance;
    }
}
