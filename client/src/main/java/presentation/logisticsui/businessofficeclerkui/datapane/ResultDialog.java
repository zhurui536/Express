package presentation.logisticsui.businessofficeclerkui.datapane;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ResultDialog extends JDialog{
        
        private JPanel panel;
        
        public ResultDialog(String string) {
                this.setLayout(null);
                this.setLocation(350,200);
                this.setSize(150,50);
                this.panel = new JPanel();
                panel.setSize(150,50);
                panel.add(new JLabel(string));
                this.setContentPane(panel);
        }
}
