package presentation.financeui;

import java.awt.Dimension;

import javax.swing.JPanel;

import bussinesslogic.financebl.FinanceController;
import bussinesslogicservice.financeblservice.FinanceBLService;
import presentation.financeui.listener.MenuListener;
import presentation.mainui.ExpressFrame;
import presentation.mainui.component.MyTool;

/**
 * Created by Away
 * 2015/12/8
 */

@SuppressWarnings("serial")
public class FinanceFrame extends ExpressFrame {

    private final String[] names = {"账户管理", "付款", "收款", "报表查看", "期初建账", "日志查看"};

    private MenuListener menuListener;
    private FinanceBLService financeController;

    public FinanceFrame() {
        this.financeController = new FinanceController();
        menuListener = new MenuListener(this);
    	paintFrame();
    }
    
    private void paintFrame(){
    	paintmenu(names, menuListener);
    	painttool();
    }

    public FinanceBLService getFinanceController() {
        return financeController;
    }
    
    public MyTool getTool() {
    	return tool;
    }

	@Override
	public void paintdata(JPanel data) {
		if(this.data != null){
			this.remove(this.data);
			data = null;
		}
		
		this.data = data;
		
		if(data != null) {
			data.setBounds(150, 100, 850, 500);
			data.setOpaque(false);
			data.setPreferredSize(new Dimension(data.getWidth(), data.getHeight()));
			this.add(data, 0);
		}
		
		this.validate();
		this.repaint();
	}
    
    
}

