import javax.swing.*;
import java.awt.*;

public class DataPanel extends JPanel {

    public static int numAmount;
    public JLabel dataLabel[] = new JLabel[numAmount];

    public DataPanel(int tab[]){
        setPreferredSize(new Dimension(200,500));
        this.numAmount = tab.length;
        System.out.println(numAmount);
        setLayout(new GridBagLayout());
        for(int i=0; i < numAmount; i++){
            GridBagConstraints gc = new GridBagConstraints();

            gc.weightx = 1;
            gc.weighty = 0.2;

            gc.gridx = 0;
            gc.gridy = i;
            gc.fill = GridBagConstraints.NONE;
            gc.anchor = GridBagConstraints.LINE_END;
            gc.insets = new Insets(0,0,0,5);

            add(new JLabel("Wartość " + Integer.toString(i+1) + ": "), gc);

            gc.gridx = 1;
            gc.gridy = i;
            gc.anchor = GridBagConstraints.LINE_START;
            gc.insets = new Insets(0,0,0,0);
            add(new JLabel(Integer.toString(tab[i])) , gc);
        }
    }
}
