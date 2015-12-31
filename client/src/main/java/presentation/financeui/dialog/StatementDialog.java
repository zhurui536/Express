package presentation.financeui.dialog;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.WarningDialog;
import presentation.financeui.FinanceFrame;
import presentation.financeui.datapanel.StatementPanel;
import presentation.mainui.ExpressFrame;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.DateChooser;
import util.ResultMessage;
import util.Time;
import vo.financevo.StatementVO;

/**
 * Created by Away
 * 2015/12/9
 */

@SuppressWarnings("serial")
public class StatementDialog extends InputFrame {

	private DateChooser start;
	private DateChooser end;
    private FinanceBLService financeController;
    private FinanceFrame ui;
    
    private JTable payTable;
    private JTable receiptTable;
    
    public StatementDialog(ExpressFrame ui) {
        super(ui);
        this.ui = (FinanceFrame) ui;
        this.financeController = ((FinanceFrame)ui).getFinanceController();
        init(ui);
    }

    private void init(Frame ui) {
        this.setLayout(null);
        this.setBounds(ui.getX() + 300, ui.getY() + 200, 400, 220);
        this.setBackgroundSize(400, 220);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();

        JButton ok = new ToolButton(150, 130,"确定");
        ok.setSize(80, 30);
        ok.addActionListener(new okListener());

        JLabel sTime = new JLabel("开始时间");
        sTime.setBounds(50, 20, 80, 50);

        JLabel eTime = new JLabel("结束时间");
        eTime.setBounds(50, 70, 80, 50);
        
        start = new DateChooser(this);
        start.setBounds(130, 30, 200, 30);
        
        end = new DateChooser(this);
        end.setBounds(130, 80, 200, 30);
        
        panel.setLayout(null);
        panel.add(ok);
        panel.add(sTime);
        panel.add(eTime);
        panel.add(start);
        panel.add(end);
        this.setContentPane(panel);
    }

    private class okListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	Time sTime = new Time(start.getDateField().getText());
        	Time eTime = new Time(end.getDateField().getText());
        	if (isAfter(sTime, eTime)) {
        		new WarningDialog(ui, "开始日期必须早于结束日期");
        		return;
        	} else {
        		processStatement(sTime, eTime);
        	}
        }
    }
	
    private void processStatement(Time sTime, Time eTime) {
    	ResultMessage msg = financeController.showStatement(sTime, eTime);
        if (isFail(msg)) {
            new WarningDialog(ui, "生成失败！");
        	System.out.println(msg.getKey());
        } else {
        	StatementVO statementVO = (StatementVO) msg.getValue();
            StatementPanel statementPanel = new StatementPanel(statementVO);
            ui.paintdata(statementPanel);
            payTable = statementPanel.getPayTable();
            System.err.println("py: " + payTable == null);
            receiptTable = statementPanel.getReceiptTable();
            this.setVisible(false);
        }
	}
    
    private boolean isAfter(Time startTime, Time endTime) {
        return startTime.compareTo(endTime) > 0;
    }
    
    private boolean isFail(ResultMessage message) {
        return message.getKey().equals("fail");
    }
    
    public JTable getPayTable() {
    	return payTable;
    }
    
    public JTable getReceiptTable() {
    	return receiptTable;
    }
    
    public void setEmpty() {
    	payTable = null;
    	receiptTable = null;
    }
}
