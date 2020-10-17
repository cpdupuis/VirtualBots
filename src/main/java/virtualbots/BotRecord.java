package virtualbots;

class BotRecord {
    private final Bot bot;
    private final BotState botState;
    private int score;

    BotRecord(Bot bot, BotState botState) {
        this.bot = bot;
        this.botState = botState;
        this.score = 0;
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

    void incrementScore() {
        ++score;
    }
}
