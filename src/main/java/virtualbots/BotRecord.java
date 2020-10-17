package virtualbots;

class BotRecord {
    private final Bot bot;
    private final BotState botState;

    BotRecord(Bot bot, BotState botState) {
        this.bot = bot;
        this.botState = botState;
    }

    Bot getBot() {
        return bot;
    }

    BotState getBotState() {
        return botState;
    }
}