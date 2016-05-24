import javax.swing.*;
import java.awt.*;

public class Prog611 extends JFrame
{
    public static void main (String[] args)
    {
        // Creates new object of class Frame611
        Frame611 f = new Frame611();
        // Closes program when exited
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Makes sure the window pops up
        f.setVisible(true);
    }
}

class Frame611 extends JFrame
{
    public Frame611()
    {
        setTitle("611 rocks!");
        setSize(300, 200);
        setLocation(50, 100);

        Panel611 panel = new Panel611();
        Container cp = getContentPane();
        cp.add(panel);
    }
}

class Panel611 extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // To move
        g.drawString("Hi", 0, 200);
    }
}