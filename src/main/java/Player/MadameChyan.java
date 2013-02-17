package Player;

public class MadameChyan extends Role {
    public MadameChyan(Callback forwarding, Callback forwarded) {
        super(forwarding, forwarded);
    }

    public String getPromptMessage() {
        return "钱夫人>";
    }
}