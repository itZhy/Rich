package Player;

public class UncleTuu extends Role {
    public UncleTuu(Callback forwarding, Callback forwarded) {
        super(forwarding, forwarded);
    }

    public String getPromptMessage() {
        return "阿土伯>";
    }
}
