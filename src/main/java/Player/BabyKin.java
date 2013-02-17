package Player;

public class BabyKin extends Role {
    public BabyKin(Callback forwarding, Callback forwarded)    {
        super(forwarding, forwarded);
    }

    public String getPromptMessage() {
        return "金贝贝>";
    }
}
