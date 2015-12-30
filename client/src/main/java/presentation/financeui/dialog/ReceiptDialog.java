package presentation.financeui.dialog;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.financeui.FinanceFrame;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.DateChooser;
import util.Time;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class ReceiptDialog extends InputFrame {

	private DateChooser dateChooser;
    private JTextField id;
    private Time time;
    private String ID;
    
    public ReceiptDialog(FinanceFrame ui) {
        super(ui);
        init(ui);
    }

    private void init(Frame ui) {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 200);
        this.setBackgroundSize(400, 200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();

        JButton ok = new ToolButton(150, 120,"确定");
        ok.setSize(80, 30);
        ok.addActionListener(new okListener());

        JLabel time = new JLabel("时间");
        time.setBounds(50, 20, 80, 50);

        dateChooser = new DateChooser(this);
        dateChooser.setBounds(105, 30, 200, 30);

        JLabel id = new JLabel("营业厅id");
        id.setBounds(50, 70, 80, 50);

        this.id = new JTextField();
        this.id.setBounds(120, 80, 130, 30);

        panel.setLayout(null);
        panel.add(ok);
        panel.add(id);
        panel.add(this.id);
        panel.add(time);
        panel.add(dateChooser);
        this.setContentPane(panel);
    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            time = new Time(dateChooser.getDateField().getText());
            ID = id.getText();
            close();
        }
    }
    
    private void close() {
        this.setVisible(false);
    }
    
    public Time getTime() {
        return time;
    }
    
    public String getID() {
        return ID;
    }


}
