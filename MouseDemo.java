import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MouseDemo extends Canvas implements MouseListener
{
    private Color curColor;
    private String curMessage;
    private int count = 0;
    private Image pepeFace;
    private final File sadPepe = new File("sad_pepe.png");
    private final File happyPepe = new File("happy_pepe.png");

    public final static int MAX_WIDTH = 1024;
    public final static int MAX_HEIGHT = 768;

    public MouseDemo()
    {
        addMouseListener(this);
        try
        {
            pepeFace = ImageIO.read(happyPepe);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        curColor = Color.BLACK;
        curMessage = "Pepe is happy :)";
    }

    public void paint( Graphics g )
    {
        int xPepe = new Random().nextInt(MAX_WIDTH - 250);
        int yPepe = new Random().nextInt(MAX_HEIGHT - 250);
        g.setColor(curColor);
        g.setFont(Font.decode("Impact-REGULAR-24"));
        g.drawString(curMessage, 400, 100);
        g.drawString(Integer.toString(count), 100, 100);

        g.drawImage(pepeFace, xPepe, yPepe, this);
    }

    @Override
    public void mouseClicked( MouseEvent evt )
    {
        count += 1;

        if((count & 0b1) == 0)
        {
            try
            {
                pepeFace = ImageIO.read(happyPepe);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            curMessage = "Happy pepe.";
        }
        else
        {
            try
            {
                pepeFace = ImageIO.read(sadPepe);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            curMessage = "Sad pepe.";
        }

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered( MouseEvent evt )
    {
        try
        {
            pepeFace = ImageIO.read(happyPepe);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        curMessage = "Pepe is happy you're here :)";
        repaint();
    }

    @Override
    public void mouseExited( MouseEvent evt )
    {
        try
        {
            pepeFace = ImageIO.read(sadPepe);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        curMessage = "Pepe is sad you left :(";
        repaint();
    }

    public static void main(String[] args)
    {
        // You can change the title or size here if you want.
        JFrame win = new JFrame("MouseDemo");
        win.setSize(MAX_WIDTH, MAX_HEIGHT);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.add( new MouseDemo() );
        win.setVisible(true);
    }


}