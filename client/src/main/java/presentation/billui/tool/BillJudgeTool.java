package presentation.billui.tool;

import javax.swing.JButton;
import javax.swing.JComboBox;

import presentation.mainui.ToolPane;
import presentation.billui.listener.BillJudgeToolListener;
import util.BillType;

@SuppressWarnings("serial")
public class BillJudgeTool extends ToolPane{
	public JComboBox<String> billType;
	
	public BillJudgeTool(BillJudgeToolListener tl){
		super.buttons = new JButton[4];
		
		buttons[0] = new JButton("全部审批");
		buttons[0].setSize(105, 25);
		buttons[0].setLocation(145, 40);
		buttons[0].addActionListener(tl);
		this.add(buttons[0]);
		
		buttons[1] = new JButton("返回");
		buttons[1].setSize(100, 30);
		buttons[1].setLocation(880, 35);
		buttons[1].addActionListener(tl);
		this.add(buttons[1]);
		
		buttons[2] = new JButton("单据刷新");
		buttons[2].setSize(105, 25);
		buttons[2].setLocation(300, 40);
		buttons[2].addActionListener(tl);
		this.add(buttons[2]);
		
		billType = new JComboBox();
		for(int i=0;i<types.length;i++){
			billType.addItem(typeToString(types[i]));
		}
		billType.setBounds(420, 40, 200, 30);
		this.add(billType);
		
		buttons[3] = new JButton("类型筛选");
		buttons[3].setBounds(623, 40, 100, 40);
		buttons[3].addActionListener(tl);
		this.add(buttons[3]);
	}
	
	private final BillType[] types = {
			BillType.OUTSTORE, BillType.INSTORE, BillType.PAYMENT, BillType.RECEIPT, BillType.ARRIVAL, BillType.DELIVERY,
			BillType.LOADING, BillType.SEND, BillType.TRANSIT
	};
	
	private String typeToString(BillType type){
		String billname;
		if(type == BillType.INSTORE){
			billname = "入库单";
		}
		else if(type == BillType.OUTSTORE){
			billname = "出库单";
		}
		else if(type == BillType.PAYMENT){
			billname = "付款单";
		}
		else if(type == BillType.RECEIPT){
			billname = "接收单";
		}
		else if(type == BillType.ARRIVAL){
			billname = "到达单";
		}
		else if(type == BillType.DELIVERY){
			billname = "派件单";
		}
		else if(type == BillType.SEND){
			billname = "寄件单";
		}
		else if(type == BillType.TRANSIT){
			billname = "中转单";
		}
		else if(type == BillType.LOADING){
			billname = "装车单";
		}
		else
			billname = "未知类型";
		
		return billname;
	}
}
