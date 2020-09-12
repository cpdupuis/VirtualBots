package virtualbots;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BotRunner {
    private final List<BotRecord> botRecords;

    public BotRunner(List<Bot> bots) {
        this.botRecords = new ArrayList<>();
        bots.forEach(bot -> botRecords.add(new BotRecord(bot)));
    }

    public void robotsInit() {
        botRecords.forEach(botRecord -> botRecord.getBot().robotInit());
    }

    public void autonomousInit() {
        botRecords.forEach(botRecord -> botRecord.getBot().autonomousInit());
    }
    
    public void autonomousPeriodic() {
        for (var botRecord : botRecords) {
            long start = System.nanoTime();
            botRecord.getBot().autonomousPeriodic();
            long end = System.nanoTime();
            botRecord.updateTimeRecords(end - start);
        }
    }


    public Map<String, Long> getTotalTimeByBotname() {
        final Map<String,Long> result = new HashMap<>();
        botRecords.forEach(botRecord -> result.put(botRecord.getBot().getName(), botRecord.getTotalRunningTime()));
        return result;
        
    }
}

class BotRecord {
    private final Bot bot;
    private long totalRunningTime;
    private long maxTimeForTick;

    BotRecord(Bot bot) {
        this.bot = bot;
        totalRunningTime = 0;
        maxTimeForTick = 0;
    }

    Bot getBot() {
        return bot;
    }

    void updateTimeRecords(long currentRunningTime) {
        totalRunningTime += currentRunningTime;
        if (currentRunningTime > maxTimeForTick) {
            maxTimeForTick = currentRunningTime;
        }
    }

    long getTotalRunningTime() {
        return totalRunningTime;
    }

    long getMaxTimeForTick() {
        return maxTimeForTick;
    }
}