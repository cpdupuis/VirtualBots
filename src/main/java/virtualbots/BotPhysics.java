package virtualbots;

public interface BotPhysics {
    public BotState tick(BotState currentState, double throttleLeft, double throttleRight, long timeIntervalNanos);
}
