import java.awt.*;
import java.util.Random;
import javax.swing.JFrame;

public class ForestAndTrees extends Canvas
{
    private static final int MAX_HEIGHT = 768;
    private static final int MAX_WIDTH = 1024;

    public void paint(Graphics g)
    {
        drawForest(g, 0, 0, 600, 600);
    }

    public void drawTree(Graphics g, int x, int y)
    {

        Color brown = new Color(132, 82, 0);
        g.setColor(brown);
        g.fillRect(x + 17, y + 50, 16, 50);

        g.setColor(Color.GREEN);
        Polygon leaves = new Polygon();
        leaves.addPoint(x + 25, y);
        leaves.addPoint(x + 50, y + 75);
        leaves.addPoint(x, y + 75);
        g.fillPolygon(leaves);
    }

    public void drawForest(Graphics g, int x, int y, int w, int h)
    {
        int xTree;
        int yTree;

        g.setColor(Color.BLACK);
        g.drawRect(x, y, w, h);

        for(int i = 0; i < 100; i++)
        {
            xTree = new Random().nextInt(w - 50);
            yTree = new Random().nextInt(h - 100);
            drawTree(g, xTree, yTree);
        }
    }

    public static void main(String[] args)
    {
        JFrame window = new JFrame("Forest and Trees");
        window.setSize(MAX_WIDTH, MAX_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ForestAndTrees forest = new ForestAndTrees();
        window.add(forest);
        window.setVisible(true);
    }
}
