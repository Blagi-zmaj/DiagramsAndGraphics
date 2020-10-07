import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String [] args){
        ArrayList<Integer> numList = new ArrayList<Integer>();

        String graph[] = {"Diagram kołowy", "Wykres liniowy", "Wszystkie", "Kształty", "Koniec"};
        JFrame frame = new JFrame();
        JFrame frame1 = new JFrame();
        JFrame frame2 = new JFrame();
        JFrame frame3 = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(600,400));
        frame2.setPreferredSize(new Dimension(600,400));
        frame3.setPreferredSize(new Dimension(600,400));
        frame1.setPreferredSize(new Dimension(600,400));
        int [] tablica = {11, 9, 21, 22,2, 12};

        DataPanel dataPanel = new DataPanel(tablica);
        frame.add(dataPanel, BorderLayout.EAST);
        int response = JOptionPane.showOptionDialog(null, "Wybierz sposób wyświetlenia danych",
                "GraphTypes",0,JOptionPane.INFORMATION_MESSAGE,null, graph, graph[0]);

        if(response == 0){
            CircleDiagram diagram = new CircleDiagram(tablica);
            frame.setSize(new Dimension(600,400));
            frame.add(diagram, BorderLayout.WEST);
            diagram.setPosition(frame);
            frame.setVisible(true);
        } else if (response == 1){
            Chart chart = new Chart(tablica.length, tablica);
            chart.setPosition(frame1);
            frame1.add(chart);
            frame1.setVisible(true);
        } else if(response == 2){
            CircleDiagram diagram = new CircleDiagram(tablica);
            frame.add(diagram);
            frame.setLocation(100,100);
            Chart chart = new Chart(tablica.length, tablica);
            chart.setPosition(frame1);
            frame1.add(chart);
            frame1.setLocation(700, 100);
            frame.setVisible(true);
            frame1.setVisible(true);
        } else if ( response == 3){
            Shape shape = new Shape(20,20, 100,40, 0);
            frame1.add(shape);
            frame1.setVisible(true);
            frame1.pack();
        } else {
            System.exit(0);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame1.pack();
    }
}
