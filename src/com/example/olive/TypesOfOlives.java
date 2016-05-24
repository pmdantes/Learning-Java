package src.com.example.olive;

public enum TypesOfOlives
{
    BLACK("black"),
    GREEN("green"),
    BROWN("brown");

    private String type;

    TypesOfOlives(String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return this.type;
    }
}