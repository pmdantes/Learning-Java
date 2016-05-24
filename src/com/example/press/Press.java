package src.com.example.press;

import src.com.example.olive.Olive;

import java.util.List;

public class Press implements OlivePress
{

    private String name;

    public Press(PressType type)
    {
        this.setName(type.toString());
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void press(List<Olive> olivesList)
    {
        int sumOfOil = 0;
        int sumOfOlives = 0;
        StringBuilder output = new StringBuilder();

        for(Olive olive: olivesList)
        {
            sumOfOil += olive.getOil();
            sumOfOlives++;
        }

        output.append("Pressed ")
                .append(sumOfOlives)
                .append(" olives in the olive press and got ")
                .append(sumOfOil)
                .append("ml of olive oil.");
        System.out.println(output);
    }

    @Override
    public void printOlivesList(List<Olive> olivesList)
    {
        StringBuilder output = new StringBuilder();
        int black = 0;
        int green = 0;
        int brown = 0;

        for(Olive olive: olivesList)
        {
            switch (olive.getType())
            {
                case "black":
                    black += 1;
                    break;
                case "green":
                    green += 1;
                    break;
                case "brown":
                    brown += 1;
                    break;

            }
        }

        output.append("There are ")
                .append(black)
                .append(" black olives, ")
                .append(green)
                .append(" green olives, ")
                .append(brown)
                .append(" brown olives.");

        System.out.println(output);
    }

}
