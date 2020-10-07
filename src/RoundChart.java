import javax.swing.*;
import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;

public class RoundChart extends JPanel {

    private static final int BORDER_GAP = 50;
    private int numValues[];
    private int dataAmount;
    private BasicStroke stroke = new BasicStroke(2.5F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

    public RoundChart(int amount, int [] tab){
        setPreferredSize(new Dimension(600,500));
        this.dataAmount = amount;
        this.numValues = tab;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setBackground(Color.DARK_GRAY);
        graphics2D.drawLine(BORDER_GAP+5, getHeight() - BORDER_GAP+5, getWidth() - BORDER_GAP +5, (getHeight() - BORDER_GAP) + 5);
        graphics2D.drawLine(getWidth()-BORDER_GAP+5, getHeight() - BORDER_GAP+5, getWidth()-BORDER_GAP - 10, getHeight() - BORDER_GAP - 10 );
        graphics2D.drawLine(getWidth()-BORDER_GAP+5, getHeight() - BORDER_GAP+5, getWidth()-BORDER_GAP - 10, getHeight() - BORDER_GAP + 20 );

        graphics2D.drawLine(BORDER_GAP+5, BORDER_GAP+5, BORDER_GAP+5, getHeight()-BORDER_GAP+5);
        graphics2D.drawLine(BORDER_GAP+5, BORDER_GAP+5, BORDER_GAP + 20, BORDER_GAP + 20);
        graphics2D.drawLine(BORDER_GAP+5, BORDER_GAP+5, BORDER_GAP - 10 , BORDER_GAP + 20 );

        graphics2D.setStroke(stroke);
        //scaling for x and y
        int xScale = (getWidth() - 2 * BORDER_GAP )/ (dataAmount);
        int yScale = ((getHeight()- 2 * BORDER_GAP) / getMaxScore(numValues));

        //show axes for x
        for(int i=0; i<numValues.length; i++){
            //Version with short axes
            int x0 = (int)((i * xScale) + BORDER_GAP)+5;
            int y0 = getHeight() - BORDER_GAP+5;
            int x1 = (int)((i * xScale) + BORDER_GAP) +5;
            int y1 = (getHeight() - BORDER_GAP) - 20+5;
            graphics2D.drawLine(x0,y0,x1,y1);

            //Version with all highlines
//            int x0 = (int)((i * xScale) + BORDER_GAP)+5;
//            int y0 = getHeight() - BORDER_GAP+5;
//            int x1 = (int)((i * xScale) + BORDER_GAP) +5;
//            int y1 = BORDER_GAP + 15;
//            graphics2D.drawLine(x0,y0,x1,y1);
        }

        //show axes for y
        for(int i=0; i < getMaxScore(numValues); i++){
//            Version with short axes
            int x0 = BORDER_GAP+5;
            int y0 = getHeight()-BORDER_GAP-(int)(i * yScale)+5;
            int x1 = BORDER_GAP + 20+5;
            int y1 = y0;
            graphics2D.drawLine(x0,y0,x1,y1);

            //Version with all highlines
//            int x0 = BORDER_GAP+5;
//            int y0 = getHeight()-BORDER_GAP-(int)(i * yScale)+5;
//            int x1 = getWidth()-BORDER_GAP+5;
//            int y1 = y0;
//            graphics2D.drawLine(x0, y0, x1, y1 );
        }

        List<Point> points = new ArrayList<Point>();
        for(int i=0; i<numValues.length; i++){
            int x = BORDER_GAP + (int)(i * xScale);
            int y = getHeight() - BORDER_GAP - (int)(yScale * numValues[i]);
            points.add(new Point(x,y));
        }

        graphics2D.setColor(Color.GREEN);
        for(int i = 0 ; i < numValues.length-1; i++){
            QuadCurve2D q = new QuadCurve2D.Double();
            int x0 = points.get(i).x + 5;
            int y0 = points.get(i).y + 5;
            int x1 = points.get(i+1).x+5;
            int y1 = points.get(i+1).y+5;
            int y2Position = numValues.length - 1;
            int y2 = points.get((numValues.length - y2Position)+i).y;

            int ctrlx =0 ;
            int ctrly = 0 ;
            int result = y0-y1;
            if((result) < 0){
                if(y2 < y1 ){
                    ctrlx = x0;
                    ctrly = y1;
                } else {
                    ctrlx = x1;
                    ctrly = y0;
                }

            } else if((result) >= 0){
                System.out.println( ">= 0");
                System.out.println("y0 = " + y0);
                System.out.println("y1 = " + y1);
                 ctrlx = x0;
                 ctrly = y1;
            }

            q.setCurve(x0, y0, ctrlx, ctrly, x1, y1);
            graphics2D.draw(q);
        }

        for(int i = 0; i<numValues.length; i++){
            Stroke stroke = graphics2D.getStroke();
            graphics2D.setStroke(new BasicStroke(3F));
            graphics2D.setColor(Color.MAGENTA);
            int x = points.get(i).x;
            int y = points.get(i).y;
            int ovalW = 10;
            int ovalH = 10;
            graphics2D.fillOval(x,y,ovalW, ovalH);
        }

        QuadCurve2D q = new QuadCurve2D.Double();
        graphics2D.setColor(Color.red);
        graphics2D.draw(q);
    }

    private int getMaxScore(int tab[]) {
        int maxScore = tab[0];
        for (int i=0; i<tab.length; i++) {
            if(tab[i] > maxScore){
                maxScore = tab[i];
            }
        }
        return maxScore;
    }
}
