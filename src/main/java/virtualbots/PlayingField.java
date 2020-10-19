package virtualbots;

public interface PlayingField {
    public boolean checkForScoringCondition(BotState botState);
    public void updateSimulatedSensors(BotRecord botRecord);
}
