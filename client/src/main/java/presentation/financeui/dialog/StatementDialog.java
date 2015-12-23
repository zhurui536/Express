package presentation.financeui.dialog;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.financeui.FinanceFrame;
import util.Time;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class StatementDialog extends JDialog {

    private JComboBox<String> startYear;
    private JComboBox<String> startMonth;
    private JComboBox<String> startDay;
    private JComboBox<String> endYear;
    private JComboBox<String> endMonth;
    private JComboBox<String> endDay;
    private Time sTime;
    private Time eTime;
    
    public StatementDialog(FinanceFrame ui) {
        super(ui);
        init(ui);
    }

    private void init(Frame ui) {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 220);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);

        JPanel panel = new JPanel();

        JButton ok = new JButton("确定");
        ok.setBounds(150, 130, 80, 30);
        ok.addActionListener(new okListener());

        JLabel sTime = new JLabel("开始时间");
        sTime.setBounds(50, 20, 80, 50);

        JLabel eTime = new JLabel("结束时间");
        eTime.setBounds(50, 70, 80, 50);

        startYear = new JComboBox<>();
        for (int i = 2000; i <= 2020; i++) {
            startYear.addItem(i + "");
        }
        startYear.setBounds(150, 30, 100, 30);

        startMonth = new JComboBox<>();
        for (int i = 1; i < 12; i++) {
            startMonth.addItem(i + "");
        }
        startMonth.setBounds(260, 30, 50, 30);

        startDay = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            startDay.addItem(i + "");
        }
        startDay.setBounds(320, 30, 50, 30);

        endYear = new JComboBox<>();
        for (int i = 2000; i <= 2020; i++) {
            endYear.addItem(i + "");
        }
        endYear.setBounds(150, 80, 100, 30);

        endMonth = new JComboBox<>();
        for (int i = 1; i < 12; i++) {
            endMonth.addItem(i + "");
        }
        endMonth.setBounds(260, 80, 50, 30);

        endDay = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            endDay.addItem(i + "");
        }
        endDay.setBounds(320, 80, 50, 30);
        
        panel.setLayout(null);
        panel.add(ok);
        panel.add(startYear);
        panel.add(startMonth);
        panel.add(startDay);
        panel.add(endYear);
        panel.add(endMonth);
        panel.add(endDay);
        panel.add(sTime);
        panel.add(eTime);
        this.setContentPane(panel);
    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	String sy = (String) startYear.getSelectedItem();
            String sm = (String) startMonth.getSelectedItem();
            String sd = (String) startDay.getSelectedItem();
            sTime = new Time(sy + "-" + sm + "-" + sd);
            String ey = (String) endYear.getSelectedItem();
            String em = (String) endMonth.getSelectedItem();
            String ed = (String) endDay.getSelectedItem();
            eTime = new Time(ey + "-" + em + "-" + ed);
            close();
        }
    }
	
	public Time getStartTime() {
		return sTime;
	}
	
	public Time getEndTime() {
		return eTime;
	}
	
    private void close() {
        this.setVisible(false);
    }
}
