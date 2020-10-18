package virtualbots;

import java.util.HashSet;
import java.util.Set;

public class BallCollectionPlayingField implements PlayingField {
    Set<Location> ballLocations;
    private static final double SCORING_DISTANCE = 1.0;

    public BallCollectionPlayingField() {
        ballLocations = new HashSet<>();
        // Let's start with just one location
        ballLocations.add(new Location(99.0, 27.0));
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
        // TODO Auto-generated method stub
        return false;
    }

}
