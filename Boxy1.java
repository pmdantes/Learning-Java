import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

/************************************************************************************
 **                  B O X Y  1 - make them manually                               **
 ***********************************************************************************/

public class Boxy1 extends Canvas
{
    public void paint( Graphics window )
    {
        int randx = 0;
        int randy = 0;
        int width = 0;
        int height = 0;
        Color color = null;

        //                  color       x    y   w   h
        drawBox( window, Color.YELLOW, 200, 300, 50, 30 );
        drawBox( window, Color.GREEN,  400, 220, 30, 150 );

        // draw ten more boxes -- different colors, different place)

        for(int i = 0; i < 4; i++)
        {
            randx = new Random().nextInt(800 - 100);
            randy = new Random().nextInt(600 - 100);
            width = new Random().nextInt(800 + 1);
            height = new Random().nextInt(600 + 1);
            color = new Color(new Random().nextInt(255 + 1),
                              new Random().nextInt(255 + 1),
                              new Random().nextInt(255 + 1));

            drawBox(window, color, randx, randy, width, height);

        }
    }

    public void drawBox( Graphics window, Color c, int x, int y, int width, int height)
    {
        //this code draws a 100x100 box in color c at (x,y)
        window.setColor(c);
        window.fillRect(x,y,width,height);
        // this code "erases" the center of the box by painting over it in white
        window.setColor(Color.WHITE);
        window.fillRect(x + 10, y + 10, width - 20, height - 20);
    }

    public static void main( String[] args )
    {
        Canvas canvas = new Boxy1();
        JFrame win = new JFrame("Boxy1 - make them manually");
        win.setSize(800,600);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setBackground(Color.WHITE);
        win.add( canvas );
        win.setVisible(true);
    }
}