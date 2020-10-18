package virtualbots;

public interface GameDisplay {
    // Update the display for one bot
    public void updateDisplay(BotRecord botRecord);
    public void displayWinner(BotRecord botRecord);
}
