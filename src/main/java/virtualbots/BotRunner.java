package virtualbots;

import java.util.List;

public class BotRunner {
    private final List<BotRecord> botRecords;
    private final BotPhysics botPhysics;
    private final PlayingField playingField;
    private final GameDisplay gameDisplay;

    public BotRunner(List<BotRecord> botRecords, BotPhysics botPhysics, PlayingField playingField, GameDisplay gameDisplay) {
        this.botRecords = botRecords;
        this.botPhysics = botPhysics;
        this.playingField = playingField;
        this.gameDisplay = gameDisplay;
    }

    public void robotsInit() {
        botRecords.forEach(botRecord -> {
            botRecord.getBot().robotInit();
            gameDisplay.updateDisplay(botRecord);
        });
    }

    public void autonomousInit() {
        botRecords.forEach(botRecord -> {
            botRecord.getBot().autonomousInit();
            gameDisplay.updateDisplay(botRecord);
        });
    }
    
    public void autonomousPeriodic() {
        for (var botRecord : botRecords) {
            Bot bot = botRecord.getBot();
            bot.autonomousPeriodic(); // Let the bot react to the world around it
            botPhysics.tick(botRecord.getBotState(), bot.getLeftSpeedController().get(), bot.getRightSpeedController().get()); // Update the world
            if (playingField.checkForScoringCondition(botRecord.getBotState())) {
                botRecord.incrementScore();
            }
            playingField.updateSimulatedSensors(botRecord);
            gameDisplay.updateDisplay(botRecord);
        }
    }

}