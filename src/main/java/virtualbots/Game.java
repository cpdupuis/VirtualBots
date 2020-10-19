package virtualbots;

import java.security.SecureRandom;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Game {
    private static final SecureRandom random = new SecureRandom();
    private static final int BALL_COUNT = 1;
    private static final int TICK_INTERVAL_MILLIS = 10; // 10 milliseconds
    // Everything on the field is generated in the rectangle defined by (0,0) and (maxX,maxY)
    // (though there are no barriers at this point)
    private final List<BotRecord> botRecords;
    private final BotRunner botRunner;
    private final BotPhysics botPhysics;
    private final GameDisplay gameDisplay;

    public Game(List<Bot> bots, double maxX, double maxY, GameDisplay gameDisplay) {
        botRecords = bots.stream().map(
            bot -> new BotRecord(bot, new BotState(random.nextDouble() * maxX, random.nextDouble() * maxY, random.nextDouble() * 2.0 * Math.PI)))
            .collect(Collectors.toList());

        PlayingField playingField = new BallCollectionPlayingField(BALL_COUNT, maxX, maxY);
        this.gameDisplay = gameDisplay;
        botPhysics = new EasyBotPhysics();
        botRunner = new BotRunner(botRecords, botPhysics, playingField, gameDisplay);
    }

    private static final Comparator<BotRecord> botRecordComparator = new Comparator<>() {

        @Override
        public int compare(BotRecord o1, BotRecord o2) {
            return o1.getScore() - o2.getScore();
        }
    };
    public void play(long timeLimitSeconds) throws InterruptedException {
        long startTime = System.nanoTime();
        long timeInterval = 1000000000L*timeLimitSeconds;

        botRunner.robotsInit();
        botRunner.autonomousInit();
        while (System.nanoTime() - startTime < timeInterval) {
            botRunner.autonomousPeriodic();
            Thread.sleep(TICK_INTERVAL_MILLIS);
        }
        Optional<BotRecord> optWinner = botRecords.stream().collect(Collectors.maxBy(botRecordComparator));
        optWinner.ifPresent(winner -> gameDisplay.displayWinner(winner));
    }

}
