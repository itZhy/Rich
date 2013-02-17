package Player;

public class SunHsiaoMei extends Role {
    public SunHsiaoMei(Callback forwarding, Callback forwarded) {
        super(forwarding, forwarded);
    }

    public String getPromptMessage() {
        return "孙美美>";
    }
}
