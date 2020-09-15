package virtualbots;

// For now, all bots are drop-center with omni wheels on front and back. That means there are just 2 wheels with drive
public class BotPhysics {
    private static final double frictionAccel = 0.1; // m/s^2
    private double x;
    private double y;
    private double theta; // 0 is the y axis, -pi/2 is left, +pi/2 is right
    private double translationSpeed;
    private double rotationSpeed;
    private double maxTranslationAccel = 3.0;
    private double maxRotationAccel = 2.0;

    public void update(double throttleStraight, double throttleTurn, double timeInterval) {
        // update position based on last velocity. Translation only happens in the direction the bot is facing (or opposite)
        double dx = translationSpeed * Math.sin(theta);
        double dy = translationSpeed * Math.cos(theta);
        x += dx * timeInterval;
        y += dy * timeInterval;
        theta += rotationSpeed * timeInterval;

        // Update velocity due to throttle
        translationSpeed += throttleStraight * maxTranslationAccel * timeInterval;
        rotationSpeed += throttleTurn * maxRotationAccel * timeInterval;
        // Update velocity due to friction
        double frictionDv = frictionAccel * timeInterval;
        if (Math.abs(translationSpeed) <= frictionDv) {
            double frictionTranslation = Math.copySign(frictionDv, translationSpeed);
            translationSpeed -= frictionTranslation;
        } else {
            translationSpeed = 0.0;
        }
        if (Math.abs(rotationSpeed) <= frictionDv) {
            double frictionRotation = Math.copySign(frictionDv, rotationSpeed);
            rotationSpeed -= frictionRotation;
        } else {
            rotationSpeed = 0.0;
        }

    }

}
