package presentation.financeui.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.ReceiptPanel;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.DateChooser;
import util.ResultMessage;
import util.Time;
import vo.logisticvo.ReceiptBillVO;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class ReceiptDialog extends InputFrame {

	private DateChooser dateChooser;
    private JTextField id;
    private FinanceBLService financeController;
    private FinanceFrame ui;
    
    public ReceiptDialog(FinanceFrame ui) {
        super(ui);
        this.financeController = ui.getFinanceController();
        this.ui = ui;
        init();
    }

    private void init() {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 200);
        this.setBackgroundSize(400, 200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = (JPanel) this.getContentPane();

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
        panel.add(ok, 0);
        panel.add(id, 0);
        panel.add(this.id, 0);
        panel.add(time, 0);
        panel.add(dateChooser, 0);
    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Time time = new Time(dateChooser.getDateField().getText());
            String ID = id.getText();
            if (check(time, ID)) {
            	processShow(time, ID);
            	close();
            }
        }

    }
    
    private boolean check(Time time, String id) {
    	return true;
    }
    
    private void close() {
        this.setVisible(false);
    }
    
    private void processShow(Time time, String id) {
		ResultMessage msg = financeController.showReceipt(time, id);
		if (isFail(msg)) {
            new WarningDialog(ui, "生成失败！");
		} else {
			@SuppressWarnings("unchecked")
			java.util.List<ReceiptBillVO> billVOList = (java.util.List<ReceiptBillVO>) msg.getValue();
			ReceiptPanel receiptPanel = new ReceiptPanel(billVOList);
			ui.paintdata(receiptPanel);
//            new WarningDialog(ui, "生成成功！");
		}	
	}
	private boolean isFail(ResultMessage msg) {
		return msg.getValue().equals("fail");
	}

}
