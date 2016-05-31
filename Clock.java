import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class Clock
{
    public static ClockFace clockCanvas     = null;
    public static Graphics clockGraphics    = null;
    public static Image clockImage          = null;


    public static int clockRadius = 0;
    public static double minuteLength = 0;
    public static double hourLength   = 0;
    public static double secondLength = 0;

    public static void main(String[] args)
    {
        clockRadius = 400;
        minuteLength = (double) clockRadius - 90.0;
        hourLength   = (double) clockRadius - 150.0;
        secondLength = (double) clockRadius - 120.0;
        
        JFrame window = new JFrame("Clock Face");
        window.setSize(800, 800);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        clockCanvas = new ClockFace(null);
        window.add(clockCanvas);
        window.setVisible(true);
        clockImage = clockCanvas.createImage(800, 800);
        clockGraphics = clockImage.getGraphics();
        clockCanvas.setImage(clockImage);


        
        start();
        
    }
    
    public static void start()
    {
        while(true)
        {
            final double hourInterval = 2.0 * Math.PI / 11.0;
            final double minInterval = 2.0 * Math.PI / 59.0;

            Calendar time = Calendar.getInstance();
            int hour = time.get(Calendar.HOUR);
            int minute = time.get(Calendar.MINUTE);
            int second = time.get(Calendar.SECOND);

            double minAngle = (double) minute * minInterval;
            double hourAngle = (double) hour * hourInterval;
            double secAngle = (double) second * minInterval;

            int xMinuteTip = (int) (Math.cos((-(Math.PI) / 2) + minAngle) * minuteLength);
            int yMinuteTip = (int) (Math.sin((-(Math.PI) / 2) + minAngle) * minuteLength);
            int xHourTip = (int) (Math.cos((-(Math.PI) / 2) + hourAngle) * hourLength);
            int yHourTip = (int) (Math.sin((-(Math.PI) / 2) + hourAngle) * hourLength);
            int xSecondTip = (int) (Math.cos((-(Math.PI) / 2) + secAngle) * secondLength);
            int ySecondTip = (int) (Math.sin((-(Math.PI) / 2) + secAngle) * secondLength);

            clockGraphics.clearRect(0, 0, 800, 800);

            // Draw clock face
            clockGraphics.setColor(Color.white);
            clockGraphics.fillOval(0, 0, clockRadius * 2, clockRadius * 2);
            clockGraphics.setColor(Color.black);
            clockGraphics.drawOval(0, 0, clockRadius * 2, clockRadius * 2);

            // Draw 3, 6, 9, 12
            clockGraphics.setColor(Color.blue);
            clockGraphics.setFont(new Font("Impact", Font.BOLD, 40));
            clockGraphics.drawString("3", (clockRadius * 2) - 20, clockRadius);
            clockGraphics.drawString("6", clockRadius, (clockRadius * 2) - 20);
            clockGraphics.drawString("9", 20, clockRadius);
            clockGraphics.drawString("12", clockRadius, 20);

            // Draw arms
            clockGraphics.setColor(Color.black);
            // Minute
            clockGraphics.drawLine(clockRadius, clockRadius, clockRadius + xMinuteTip, clockRadius + yMinuteTip);
            // Hour
            clockGraphics.drawLine(clockRadius, clockRadius, clockRadius + xHourTip, clockRadius + yHourTip);
            // Second
            clockGraphics.setColor(Color.red);
            clockGraphics.drawLine(clockRadius, clockRadius, clockRadius + xSecondTip, clockRadius + ySecondTip);

            clockCanvas.repaint();

            Thread thread = new Thread();
            thread.start();
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}


class ClockFace extends Canvas
{

    private Image face;
    
    public ClockFace(Image img)
    {
        this.face = img;
    }
    
    public void setImage(Image img)
    {
        this.face = img;
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(face, 0, 0, this);
    }
    public void update(Graphics g)
    {
        paint(g);
    }

}
