import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class CircleDiagram extends JPanel implements setFramePosition {

    private double startValueCircle = 0;
    private double extendValue = 0;
    private int tabValue[];
    private double percentValue[];
    private double degreesAmount = 0;
    private double sum = 0;

    public CircleDiagram(int [] tab){
        setPreferredSize(new Dimension(600,500));
        this.tabValue = tab;
        for(int i=0; i<tab.length; i++){
            sum += (double)tabValue[i];

        }
        percentValue = new double[tabValue.length];
        for(int i=0; i<tabValue.length; i++){
            percentValue[i] = (double)(tabValue[i]/sum) * 100;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color color[] = new Color[tabValue.length];
        int j = 40;
        for(int i=0; i<tabValue.length; i++){
            color[i] = new Color(j-15,j-10,j-20);
            j+=25;
        }

        Graphics2D graphics2D = (Graphics2D)g;
        for(int i=0; i<tabValue.length; i++){
            graphics2D.setColor(color[i]);
            degreesAmount = (360*percentValue[i])/100;
            graphics2D.fill(new Arc2D.Double(50F, 50F, 280F, 260F, startValueCircle += extendValue, extendValue = degreesAmount, Arc2D.PIE));
        }
    }

    @Override
    public void setPosition(JFrame frame) {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        frame.setPreferredSize(new Dimension(700,400));
        int widthBorder = (width - frame.getWidth())/ 3;
        int heightBorder = (height - frame.getHeight())/ 4;
        frame.setLocation(widthBorder, heightBorder);
    }
}
