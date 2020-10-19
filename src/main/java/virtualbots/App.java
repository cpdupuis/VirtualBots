package virtualbots;

import java.util.List;

import virtualbots.bots.DemoBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class App {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws InterruptedException {
        logger.info("Starting");
        Bot bot = new DemoBot();
        GameDisplay gameDisplay = new TerminalGameDisplay();
        Game game = new Game(List.of(bot), 10.0, 10.0, gameDisplay);
        game.play(10);
    }
}
