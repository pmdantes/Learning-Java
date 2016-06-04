import java.awt.*;
import java.util.Random;
import javax.swing.JFrame;

public class SmilingFaceFunction extends Canvas
{
    public void paint( Graphics g )
    {
        int x = 0;
        int y = 0;
        drawSmilingFace(g,100,100);
        drawSmilingFace(g,400,350);
        for(int i = 0; i < 10; i++)
        {
            x = new Random().nextInt(1024 - 40);
            y = new Random().nextInt(768 - 40);
            drawSmilingFace(g, x, y);
        }
    }

    public void drawSmilingFace( Graphics g, int x, int y )
    {
        // Draws a smiling face on the screen, where the point (x,y) is
        //  the upper-left corner of a box containing the face.

        // draw circle for the head
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, 40, 40);

        // draw eyes
        g.setColor(Color.BLACK);
        g.fillOval(x + 10 - 3, y + 10, 6, 6);
        g.fillOval(x + 30 - 3, y + 10, 6, 6);

        // draw mouth
        g.drawArc(x + 10, y + 10, 20, 20, 225, 90);
    }

    public static void main(String[] args)
    {
        // You can change the title or size here if you want.
        JFrame win = new JFrame("Smiling Face Function");
        win.setSize(1024,768);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.add( new SmilingFaceFunction() );
        win.setVisible(true);
    }

}