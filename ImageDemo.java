import java.awt.*;
import javax.swing.JFrame;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.Random;

public class ImageDemo extends Canvas
{
    Image coolFace;

    public ImageDemo() throws Exception
    {
        coolFace = ImageIO.read( new File("happy_pepe.png") );
        // Java supports PNG, JPEG, and GIF (but not animated GIFs). It does not support BMP.
    }

    public void paint( Graphics g )
    {
        //           Image  , x,  y, this
        int width = this.coolFace.getWidth(null);
        int height = this.coolFace.getHeight(null);

        int x = new Random().nextInt(1024 - width);
        int y = new Random().nextInt(768 - height);
        g.drawImage(coolFace, x, y, this);

        // And, just for fun, let's give me a halo! This halo designed by Liz O in 2012.
        g.setColor( Color.yellow );
        g.drawOval(88,88,70,25);
    }

    public static void main(String[] args) throws Exception
    {
        JFrame win = new JFrame("Image Demo");
        win.setSize(1024,768);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.add( new ImageDemo() );
        win.setVisible(true);
    }


}