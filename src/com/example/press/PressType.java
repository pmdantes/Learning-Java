package src.com.example.press;

public enum PressType
{

    KITCHEN_AID("Kitchen Aid"),
    HAMILTON_BEACH("Hamilton Beach"),
    CUISINART("Cuisinart");

    private String type;

    PressType(String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return this.type;
    }
}
