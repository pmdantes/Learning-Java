import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.util.Random;

/**
 * Created by PaoloDantes on 2016-06-01.
 */
public class Sierpinski
{
    public static void main(String[] args)
    {
        int x1 = 512;
        int x2 = 146;
        int x3 = 876;
        int y1 = 109;
        int y2 = 654;
        int y3 = 654;
        int x = 512;
        int y = 382;
        JFrame window = new JFrame("Sierpinski Triangle");
        SierCanvas canvas = new SierCanvas(null);
        window.setSize(1024, 768);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(canvas);
        window.setVisible(true);

        Image img = canvas.createImage(1024, 768);
        Graphics graph = img.getGraphics();
        canvas.setImg(img);

        for(int i = 0; i < 100000; i++)
        {
            graph.drawLine(x, y, x, y);
            canvas.repaint();
            int rand = new Random().nextInt(4);
            switch(rand)
            {
                case 1:
                    x -= (x - x1) / 2;
                    y -= (y - y1) / 2;
                    break;
                case 2:
                    x -= (x - x2) / 2;
                    y -= (y - y2) / 2;
                    break;
                case 3:
                    x -= (x - x3) / 2;
                    y -= (y - y3) / 2;
                    break;
            }
        }
        graph.drawString("Sierpinski Triangle", 462, 484);
        canvas.repaint();
    }
}

class SierCanvas extends Canvas
{
    private Image img = null;
    public SierCanvas(Image img)
    {
        this.img = img;
        setBackground(Color.white);
    }
    public void setImg(Image img)
    {
        this.img = img;
    }
    public void paint(Graphics g)
    {
        g.drawImage(img, 0, 0, this);
    }
    public void update(Graphics g)
    {
        paint(g);
    }
}