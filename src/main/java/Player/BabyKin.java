package Player;

public class BabyKin extends Role {
    public BabyKin(Callback callback)    {
        super(callback);
    }

    public String getPromptMessage() {
        return "金贝贝>";
    }
}
