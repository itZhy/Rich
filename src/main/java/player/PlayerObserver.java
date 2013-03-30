package player;

public interface PlayerObserver {
    public void handle(Role role, Movement movement);
}
