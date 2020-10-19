package virtualbots;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

import virtualbots.components.BallSensor;

public class BallCollectionPlayingField implements PlayingField {
    Set<Location> ballLocations;
    private static final double SCORING_DISTANCE = 1.0;
    private static final SecureRandom random = new SecureRandom();

    public BallCollectionPlayingField(int ballCount, double maxX, double maxY) {
        ballLocations = new HashSet<>();
        for (int i = 0; i<ballCount; ++i) {
            ballLocations.add(new Location(random.nextDouble() * maxX, random.nextDouble() * maxY));
        }
    }

    @Override
    public boolean checkForScoringCondition(BotState botState) {
        Location botLocation = new Location(botState.x, botState.y);
        for (var ballLocation: ballLocations) {
            if (botLocation.getDistance(ballLocation) < SCORING_DISTANCE) {
                // The robot picked up the ball!
                ballLocations.remove(ballLocation);
                return true;
            }
        }
        return false;
    }

    // Returns negative if bot should turn left or positive to turn right. Values range from -Pi to +Pi
    // Returns null if there are no balls
    public void updateBallSensor(BotRecord botRecord) {
        double bestDistance = Double.MAX_VALUE;
        Location bestLocation = null;
        BallSensor ballSensor = botRecord.getBot().getBallSensor();
        if (ballLocations.isEmpty()) {
           ballSensor.setBallDirection(null);
           ballSensor.setBallDistance(null);
            return;
        }
        Location botLocation = new Location(botRecord.getBotState().x, botRecord.getBotState().y);
        for (Location ballLocation : ballLocations) {
            double distance = botLocation.getDistance(ballLocation);
            if (distance < bestDistance) {
                bestDistance = distance;
                bestLocation = ballLocation;
            }
        }
        ballSensor.setBallDirection(botLocation.getDirection(bestLocation));
        ballSensor.setBallDistance(bestDistance);
    }

}
