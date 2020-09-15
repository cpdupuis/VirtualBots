package virtualbots.controllers;

import edu.wpi.first.wpilibj.SpeedController;

public class SimSpeedController implements SpeedController {
    private boolean isInverted;
    private double speed;
    private boolean isEnabled;
    
    @Override
    public void pidWrite(double output) {
        throw new RuntimeException("pidWrite: not implemented");
    }

    @Override
    public void set(double speed) {
        this.speed = speed;
    }

    @Override
    public double get() {
        return speed;
    }

    @Override
    public void setInverted(boolean isInverted) {
        this.isInverted = isInverted;
    }

    @Override
    public boolean getInverted() {
        return isInverted;
    }

    @Override
    public void disable() {
        isEnabled = false;

    }

    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public void stopMotor() {
        speed = 0.0;
    }
    
}
