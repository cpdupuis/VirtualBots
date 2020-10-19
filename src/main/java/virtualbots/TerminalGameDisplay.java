package virtualbots;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TerminalGameDisplay implements GameDisplay {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void updateDisplay(BotRecord botRecord) {
        logger.info(botRecord.getName() + ": score=" + botRecord.getScore()+" x="+botRecord.getBotState().x + " y="+botRecord.getBotState().y);
    }

    @Override
    public void displayWinner(BotRecord botRecord) {
        logger.info("The winner is: " + botRecord.getName() + " with " + botRecord.getScore() + " points");
    }
    
}
