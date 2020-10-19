package virtualbots.bots;

import edu.wpi.first.wpilibj.SpeedController;
import virtualbots.Bot;
import virtualbots.components.BallSensor;
import virtualbots.components.SimSpeedController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoBot implements Bot {
    private final SpeedController leftSpeedController = new SimSpeedController();
    private final SpeedController rightSpeedController = new SimSpeedController();
    private final BallSensor ballSensor = new BallSensor();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void autonomousInit() {
        logger.debug("autonomousInit");
    }

    @Override
    public void autonomousPeriodic() {
        logger.debug("autonomousPeriodic");
    }

    @Override
    public void robotInit() {
        logger.debug("robotInit");
    }

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public String getName() {
        return "Demo Bot";
    }

    @Override
    public SpeedController getLeftSpeedController() {
        return leftSpeedController;
    }

    @Override
    public SpeedController getRightSpeedController() {
        return rightSpeedController;
    }

    @Override
    public BallSensor getBallSensor() {
        return ballSensor;
    }
    
}
