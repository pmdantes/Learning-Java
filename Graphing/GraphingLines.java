package Graphing;

/**
 * Created by PaoloDantes on 2016-05-30.
 */
public class GraphingLines
{
    public static void main(String[] args)
    {
        GraphPaper graph = new GraphPaper(0,0);
        GraphPaper graph2 = new GraphPaper(300,0);

        printLine(graph, 1.0, 0.0);
        printLine(graph2, -8.0/3.0, 4.0);

    }

    private static void printLine(GraphPaper graph, double slope, double offset)
    {
        for(double i = -500; i < 500; i += 0.01)
        {
            double x;
            double y;
            x = i;
            y = slope * x + offset;
            graph.drawPoint(x, y);
        }
    }
}
