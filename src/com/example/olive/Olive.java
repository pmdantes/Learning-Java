package src.com.example.olive;

public class Olive
{
    private TypesOfOlives type;
    private int oil;

    public Olive(TypesOfOlives type, int oil)
    {
        this.type = type;
        this.oil = oil;
    }

    public String getType()
    {
        return this.type.toString();
    }

    public void setType(TypesOfOlives type)
    {
        this.type = type;
    }

    public void setOil(int oil)
    {
        this.oil = oil;
    }

    public int getOil()
    {
        return this.oil;
    }
}
