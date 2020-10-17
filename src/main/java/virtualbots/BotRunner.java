package virtualbots;

import java.util.List;

public class BotRunner {
    private final List<BotRecord> botRecords;
    private final BotPhysics botPhysics;
    private final PlayingField playingField;

    public BotRunner(List<BotRecord> botRecords, BotPhysics botPhysics, PlayingField playingField) {
        this.botRecords = botRecords;
        this.botPhysics = botPhysics;
        this.playingField = playingField;
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
            botPhysics.tick(botRecord.getBotState(), bot.getLeftSpeedController().get(), bot.getRightSpeedController().get()); // Update the world
        }
    }

}