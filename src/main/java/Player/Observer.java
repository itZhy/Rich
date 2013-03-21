package player;

public interface Observer {
    public void handle(String roleName, Movement movement);
}
