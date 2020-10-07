import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.Scanner;

public class Shape extends JPanel {

    private int xPos = 0;
    private int yPos = 0;
    private int width = 0;
    private int height = 0;
    private int radius = 0;
    private int BORDER = 20;

    public Shape(int x, int y, int width, int height, int radius){
        Scanner scanner = new Scanner(System.in);
        this.xPos = x;
        this.yPos = y;
        this.width = width;
        this.height = height;
        this.radius = radius;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D)g;
        Path2D path2D = new Path2D.Double();
        path2D.moveTo(BORDER, BORDER);
        path2D.lineTo(width + BORDER, BORDER);
        path2D.lineTo(width + BORDER, height + BORDER);
        path2D.lineTo(BORDER, height + BORDER);
        path2D.lineTo(BORDER, BORDER);

        graphics2D.draw(path2D);
        graphics2D.setColor(Color.MAGENTA);
        graphics2D.fillRect(BORDER+5, BORDER+5, width-10, height-10);

        path2D.reset();
        path2D.moveTo((BORDER * 2) + width , BORDER);
        path2D.lineTo((BORDER * 2) + (width * 2) , BORDER);
        path2D.lineTo((BORDER * 2) + (width * 2) , width + BORDER);
        path2D.lineTo((BORDER * 2) + width , width + BORDER);
        path2D.lineTo((BORDER * 2) + width  , BORDER);

        graphics2D.setColor(Color.green);
        graphics2D.draw(path2D);

        graphics2D.setColor(Color.DARK_GRAY.brighter());
        graphics2D.fillRect((BORDER * 2)+ width + 5 , BORDER + 5, width - 10, width - 10  );

        graphics2D.setColor(Color.RED);
        graphics2D.fillOval((BORDER * 3)+ (width * 2) + 5 , BORDER + 5, width - 10, height - 10  );
        graphics2D.fillOval((BORDER * 3)+ (width * 2) + 5 , BORDER + 5 + width, width - 10, width - 10  );

        graphics2D.setColor(Color.blue);
        graphics2D.drawArc(50,200, 100, 100, 0, 90);      // 0 starts from EAST (5th parameter)

        graphics2D.setColor(Color.MAGENTA);
        graphics2D.drawArc(50,200, 100,100, 0, -90);
    }
}
