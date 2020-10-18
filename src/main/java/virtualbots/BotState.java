package virtualbots;

// For now, all bots are drop-center, with drive only on center wheels. They can only move in the direction they are pointing
public class BotState {
    final double frictionAccel = 0.1; // m/s^2
    double x;
    double y;
    double theta; // 0 is the y axis, -pi/2 is left, +pi/2 is right
    double translationSpeed = 0.0;
    double rotationSpeed = 0.0;
    final double maxTranslationAccel = 3.0;
    final double maxRotationAccel = 2.0;
    long lastUpdateNanos;
    int score = 0;

    public BotState(double x, double y, double theta) {
        this.x = x;
        this.y = y;
        this.theta = theta;
        lastUpdateNanos = System.nanoTime();
    }
}
