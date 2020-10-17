package virtualbots;

// I don't think this physics model is very realistic, but it's the simplest thing I could think of
public class EasyBotPhysics implements BotPhysics {
    

    @Override
    public void tick(BotState state, double throttleLeft, double throttleRight) {
        long nowNanos = System.nanoTime();
        long timeIntervalNanos = nowNanos = state.lastUpdateNanos;
        state.lastUpdateNanos = nowNanos;
        double throttleStraight = 0.0;
        double throttleTurn = 0.0;
        double timeInterval = timeIntervalNanos / 1000000000.0;

        // update position based on last velocity. Translation only happens in the direction the bot is facing (or opposite)
        double dx = state.translationSpeed * Math.sin(state.theta);
        double dy = state.translationSpeed * Math.cos(state.theta);
        state.x += dx * timeInterval;
        state.y += dy * timeInterval;
        state.theta += state.rotationSpeed * timeInterval;

        // Update velocity due to throttle
        state.translationSpeed += throttleStraight * state.maxTranslationAccel * timeInterval;
        state.rotationSpeed += throttleTurn * state.maxRotationAccel * timeInterval;
        // Update velocity due to friction
        double frictionDv = state.frictionAccel * timeInterval;
        if (Math.abs(state.translationSpeed) <= frictionDv) {
            double frictionTranslation = Math.copySign(frictionDv, state.translationSpeed);
            state.translationSpeed -= frictionTranslation;
        } else {
            state.translationSpeed = 0.0;
        }
        if (Math.abs(state.rotationSpeed) <= frictionDv) {
            double frictionRotation = Math.copySign(frictionDv, state.rotationSpeed);
            state.rotationSpeed -= frictionRotation;
        } else {
            state.rotationSpeed = 0.0;
        }
    }

}
