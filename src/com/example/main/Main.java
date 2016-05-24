package src.com.example.main;

import src.com.example.olive.BlackOlive;
import src.com.example.olive.BrownOlive;
import src.com.example.olive.GreenOlive;
import src.com.example.olive.Olive;
import src.com.example.press.Press;
import src.com.example.press.PressType;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        List<Olive> listOfOlives = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);
        Press press = new Press(PressType.HAMILTON_BEACH);

        System.out.println("How many black olives do you have?");
        int numBlackOlives = Integer.parseInt(userInput.nextLine());

        System.out.println("How many green olives do you have?");
        int numGreenOlives = Integer.parseInt(userInput.nextLine());

        System.out.println("How many brown olives do you have?");
        int numBrownOlives = Integer.parseInt(userInput.nextLine());

        StringBuilder sb = new StringBuilder();
        sb.append("Ok the olive press has ")
          .append(numBlackOlives + numBrownOlives + numGreenOlives)
          .append(" olives in the basket");
        System.out.println(sb);

        for (int i = 0; i < numBlackOlives; i++)
        {
            listOfOlives.add(new BlackOlive());
        }
        for (int i = 0; i < numGreenOlives; i++)
        {
            listOfOlives.add(new GreenOlive());
        }
        for (int i = 0; i < numBrownOlives; i++)
        {
            listOfOlives.add(new BrownOlive());
        }

        System.out.println("What do you want to do?");
        System.out.println("1. List olives");
        System.out.println("2. Press olives");
        int start = Integer.parseInt(userInput.nextLine());

        switch(start)
        {
            case 1:
                press.printOlivesList(listOfOlives);
                break;
            case 2:
                press.press(listOfOlives);
                break;
            default:
                System.out.println("Invalid entry. Goodbye!");
                break;
        }
    }
}
