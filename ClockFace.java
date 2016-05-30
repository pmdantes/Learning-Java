import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class ClockFace extends Canvas
{
    private final Calendar calendar = Calendar.getInstance();
    private int clockRadius = 0;
    private double minuteLength = 0;
    private double hourLength   = 0;
    private double secondLength = 0;
    private static Graphics g;

    private int xMinuteTip  = 0;
    private int yMinuteTip  = 0;
    private int xHourTip    = 0;
    private int yHourTip    = 0;
    private int xSecondTip  = 0;
    private int ySecondTip  = 0;
    private int hour    = 0;
    private int minute  = 0;
    private int second  = 0;

    private void initialize()
    {
        clockRadius = getHeight() / 2;
        minuteLength = (double) clockRadius - 90.0;
        hourLength   = (double) clockRadius - 150.0;
        secondLength = (double) clockRadius - 120.0;

    }

    private void drawFace(Graphics g)
    {
        // Draw clock face
        g.setColor(Color.white);
        g.fillOval(0, 0, clockRadius * 2, clockRadius * 2);
        g.setColor(Color.black);
        g.drawOval(0, 0, clockRadius * 2, clockRadius * 2);

        // Draw 3, 6, 9, 12
        g.setColor(Color.blue);
        g.setFont(new Font("Impact", Font.BOLD, 40));
        g.drawString("3", (clockRadius * 2) - 20, clockRadius);
        g.drawString("6", clockRadius, (clockRadius * 2) - 20);
        g.drawString("9", 20, clockRadius);
        g.drawString("12", clockRadius, 20);
    }

    private void drawArms(Graphics g)
    {

        // Draw arms
        g.setColor(Color.black);
        // Minute
        g.drawLine(clockRadius, clockRadius, clockRadius + xMinuteTip, clockRadius + yMinuteTip);
        // Hour
        g.drawLine(clockRadius, clockRadius, clockRadius + xHourTip, clockRadius + yHourTip);
        // Second
        g.drawLine(clockRadius, clockRadius, clockRadius + xSecondTip, clockRadius + ySecondTip);
    }

    private void calcNewPoints()
    {
        double minAngle     = 0.0;
        double hourAngle    = 0.0;
        double secAngle     = 0.0;

        final double hourInterval    = 2.0 * Math.PI / 11.0;
        final double minuteInterval  = 2.0 * Math.PI / 59.0;

        hour    = calendar.get(Calendar.HOUR);
        minute  = calendar.get(Calendar.MINUTE);
        second  = calendar.get(Calendar.SECOND);

        minAngle    = (double) minute * minuteInterval;
        hourAngle   = (double) hour * hourInterval;
        secAngle    = (double) second * minuteInterval;

        xMinuteTip  = (int) (Math.cos((-(Math.PI) / 2) + minAngle) * minuteLength);
        yMinuteTip  = (int) (Math.sin((-(Math.PI) / 2) + minAngle) * minuteLength);
        xHourTip    = (int) (Math.cos((-(Math.PI) / 2) + hourAngle) * hourLength);
        yHourTip    = (int) (Math.sin((-(Math.PI) / 2) + hourAngle) * hourLength);
        xSecondTip  = (int) (Math.cos((-(Math.PI) / 2) + secAngle) * secondLength);
        ySecondTip  = (int) (Math.sin((-(Math.PI) / 2) + secAngle) * secondLength);
    }

    private void writeTimeText()
    {
        // Write time in text
        g.setColor(Color.red);
        g.drawString(Integer.toString(hour), clockRadius - 40, clockRadius);
        g.drawString(Integer.toString(minute), clockRadius, clockRadius);
        g.drawString(Integer.toString(second), clockRadius + 40, clockRadius);
    }

    private void start()
    {
        Thread th = new Thread();
        th.start();
        while (true)
        {

            calcNewPoints();
            drawArms(g);
            writeTimeText();
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g)
    {
        initialize();
        drawFace(g);
    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Clock Face");
        window.setSize(800, 800);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ClockFace canvas = new ClockFace();
        window.add(canvas);
        window.setVisible(true);
        canvas.start();

    }
}
