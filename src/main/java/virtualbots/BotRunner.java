package virtualbots;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BotRunner {
    private final List<BotRecord> botRecords;
    private final BotPhysics botPhysics;

    public BotRunner(List<BotRecord> botRecords, BotPhysics botPhysics) {
        this.botRecords = botRecords;
        this.botPhysics = botPhysics;
    }

    public void robotsInit() {
        botRecords.forEach(botRecord -> botRecord.getBot().robotInit());
    }

    public void autonomousInit() {
        botRecords.forEach(botRecord -> botRecord.getBot().autonomousInit());
    }
    
    public void autonomousPeriodic() {
        for (var botRecord : botRecords) {
            Bot bot = botRecord.getBot();
            bot.autonomousPeriodic(); // Let the bot react to the world around it
            botPhysics.tick(botRecord.getBotState(), bot.getLeftThrottle(), bot.getRightThrottle()); // Update the world
        }
    }

}