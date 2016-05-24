import java.util.Scanner;

public class ForgetfulMachine
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Feed a list of words:");
        String words = keyboard.nextLine();
        String[] listOfWords = words.split(" ");
        print(listOfWords);

        System.out.println("Feed a list of numbers:");
        String numbers = keyboard.nextLine();
        Double[] listOfNumbers = getInput(numbers);
        print(listOfNumbers);

    }

    static Double[] getInput(String numbers)
    {
        String[] list = numbers.split(" ");
        Double[] retList = new Double[list.length];
        for (int i = 0; i < list.length; i++)
        {
            retList[i] = Double.parseDouble(list[i]);
        }

        return retList;
    }
    static void print(String ... words)
    {
        for(String word: words)
    	{
    		System.out.println(word);
    	}
    }

    static void print(Double ... numbers)
    {
        for(Double number: numbers){
            System.out.println(number);
        }

    }
}