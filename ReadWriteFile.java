import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by PaoloDantes on 2016-06-05.
 */
public class ReadWriteFile
{
    public static void main(String[] args) throws FileNotFoundException
    {
        PrintStream file = new PrintStream(new FileOutputStream("letter.txt"));
        file.println("This is a letter");
        file.close();
    }
}
