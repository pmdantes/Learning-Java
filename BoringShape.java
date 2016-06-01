import java.awt.*;
import java.util.Random;
import javax.swing.JFrame;

public class BoringShape
{
    public static JFrame frame = null;
    public static ShapeCanvas canvas = null;
    public static Graphics graphics = null;
    public static Image image = null;

    public static void main(String[] args)
    {

        frame = new JFrame("Draw a boring triangle");
        frame.setSize(1024, 768);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = new ShapeCanvas(null);
        frame.add(canvas);
        frame.setVisible(true);
        image = canvas.createImage(1024, 768);
        graphics = image.getGraphics();
        canvas.setImage(image);

        for(int triangles = 0; triangles < 500; triangles++)
        {
            int[] xTri = getRightAngle(1024);
            int[] yTri = getRightAngle(768);
            int[] rTri = getPoints(255, 1);
            int[] gTri = getPoints(255, 1);
            int[] bTri = getPoints(255, 1);
            Polygon tri = new Polygon();
            tri.addPoint(xTri[0], yTri[0]);
            tri.addPoint(xTri[1], yTri[1]);
            tri.addPoint(xTri[0], yTri[1]);
            Color triColor = new Color(rTri[0], gTri[0], bTri[0]);
            graphics.setColor(triColor);
            graphics.fillPolygon(tri);
            canvas.repaint();

        }
    }

    public static int[] getPoints(int limit, int size)
    {
        int[] xRand = new Random().ints(0, limit).distinct().limit(size).toArray();
        return xRand;

    }
    public static int[] getRightAngle(int limit)
    {
        int firstPoint = new Random().nextInt(limit);
        int[] retArray = new int[2];
        while (firstPoint + 50 > limit)
        {
            firstPoint = new Random().nextInt(limit);
        }
        retArray[0] = firstPoint;
        retArray[1] = firstPoint + 50;
        return retArray;
    }
}

class ShapeCanvas extends Canvas
{
    private Image img;

    public ShapeCanvas(Image img) { this.img = img; }
    public void setImage(Image img) { this.img = img; }
    public void paint(Graphics g) { g.drawImage(img, 0, 0, this); }
    public void update(Graphics g) { paint(g); }
}