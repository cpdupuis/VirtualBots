package virtualbots;

// I don't think this physics model is very realistic, but it's the simplest thing I could think of
public class EasyBotPhysics {
    
    

    public void update(double throttleLeft, double throttleRight, double timeInterval) {

        double throttleStraight = 0.0;
        double throttleTurn = 0.0;



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
