package virtualbots;

// For now, all bots are drop-center with omni wheels on front and back. That means there are just 2 wheels with drive
public class BotState {
    private static final double frictionAccel = 0.1; // m/s^2
    private double x;
    private double y;
    private double theta; // 0 is the y axis, -pi/2 is left, +pi/2 is right
    private double translationSpeed;
    private double rotationSpeed;
    private double maxTranslationAccel = 3.0;
    private double maxRotationAccel = 2.0;


}
