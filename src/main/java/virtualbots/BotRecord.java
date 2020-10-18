package virtualbots;

class BotRecord {
    private final Bot bot;
    private final BotState botState;
    private int score;
    private final String name;

    BotRecord(Bot bot, BotState botState) {
        this.bot = bot;
        this.botState = botState;
        this.score = 0;
        this.name = bot.getName();
    }

    Bot getBot() {
        return bot;
    }

    BotState getBotState() {
        return botState;
    }

    int getScore() {
        return score;
    }

    String getName() {
        return name;
    }

    void incrementScore() {
        ++score;
    }

    
}
