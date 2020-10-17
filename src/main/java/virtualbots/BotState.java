package virtualbots;

// For now, all bots are drop-center with omni wheels on front and back. That means there are just 2 wheels with drive
public class BotState {
    final double frictionAccel = 0.1; // m/s^2
    double x;
    double y;
    double theta; // 0 is the y axis, -pi/2 is left, +pi/2 is right
    double translationSpeed;
    double rotationSpeed;
    double maxTranslationAccel = 3.0;
    double maxRotationAccel = 2.0;
    long lastUpdateNanos;
}
