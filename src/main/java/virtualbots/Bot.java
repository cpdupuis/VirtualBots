package virtualbots;

import edu.wpi.first.wpilibj.SpeedController;
import virtualbots.components.BallSensor;

// Your virtual robots should implement this interface
//
// This interface is based on the methods in the IterativeRobotBase class provided by the WPILib library
// used in FRC robots: https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/IterativeRobotBase.html
public interface Bot {
    // Methods defined by IterativeRobotBase
    public void autonomousInit();
    public void autonomousPeriodic();
    public void robotInit();
    public void robotPeriodic();
    public void disabledInit();
    public void disabledPeriodic();

    // Additional methods for the simulator
    public String getName();
    public SpeedController getLeftSpeedController();
    public SpeedController getRightSpeedController();
    public BallSensor getBallSensor();

}

