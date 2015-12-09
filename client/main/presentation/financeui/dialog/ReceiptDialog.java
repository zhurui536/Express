package main.presentation.financeui.dialog;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Time;
import main.bussinesslogicservice.financeblservice.FinanceBLService;
import main.presentation.financeui.FinanceFrame;
import main.presentation.financeui.datapanel.ReceiptPanel;
import main.vo.logisticvo.ReceiptBillVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Away
 * 2015/12/9
 */

public class ReceiptDialog extends JDialog {

    private JComboBox<String> year;
    private JComboBox<String> month;
    private JComboBox<String> day;
    private JTextField id;
    private FinanceBLService financeController;
    private FinanceFrame ui;

    public ReceiptDialog(FinanceFrame ui) {
        super(ui);
        init(ui);
        this.ui = ui;
        financeController = ui.getFinanceController();
    }

    private void init(Frame ui) {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(true);

        JPanel panel = new JPanel();

        JButton ok = new JButton("确定");
        ok.setBounds(150, 120, 80, 30);
        ok.addActionListener(new okListener());

        JLabel time = new JLabel("时间");
        time.setBounds(50, 20, 80, 50);

        year = new JComboBox<>();
        for (int i = 2000; i <= 2020; i++) {
            year.addItem(i + "");
        }
        year.setBounds(150, 30, 100, 30);

        month = new JComboBox<>();
        for (int i = 1; i < 12; i++) {
            month.addItem(i + "");
        }
        month.setBounds(260, 30, 50, 30);

        day = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            day.addItem(i + "");
        }
        day.setBounds(320, 30, 50, 30);

        JLabel id = new JLabel("营业厅id");
        id.setBounds(50, 70, 80, 50);

        this.id = new JTextField();
        this.id.setBounds(150, 80, 150, 30);

        panel.setLayout(null);
        panel.add(ok);
        panel.add(year);
        panel.add(month);
        panel.add(id);
        panel.add(day);
        panel.add(this.id);
        panel.add(time);
        this.setContentPane(panel);
    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String y = (String) year.getSelectedItem();
            String m = (String) month.getSelectedItem();
            String d = (String) day.getSelectedItem();
            Time time = new Time(y + "-" + m + "-" + d);
            String ID = id.getText();
            ResultMessage msg = financeController.showReceipt(time, ID);
            if (isFail(msg)) {
                // TODO
            } else {
                java.util.List<ReceiptBillVO> billVOList = (java.util.List<ReceiptBillVO>) msg.getValue();
                ReceiptPanel receiptPanel = new ReceiptPanel(billVOList);
                ui.paintData(receiptPanel);
                close();
            }
        }
    }

    private boolean isFail(ResultMessage message) {
        return message.getKey().equals("fail");
    }

    private void close() {
        this.setVisible(false);
    }
}
