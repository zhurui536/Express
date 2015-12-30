package presentation.billui.tool;

import javax.swing.JComboBox;

import presentation.billui.listener.BillJudgeToolListener;
import presentation.mainui.component.MyTool;
import util.BillType;

@SuppressWarnings("serial")
public class BillJudgeTool extends MyTool{
	public JComboBox<String> billType;
	
	public BillJudgeTool(BillJudgeToolListener tl){
		super(buttonname, tl);
		
		billType = new JComboBox<String>();
		for(int i=0;i<types.length;i++){
			billType.addItem(typeToString(types[i]));
		}
		billType.setBounds(650, 50, 200, 40);
		this.add(billType, 0);
	}
	
	private final BillType[] types = {
			BillType.OUTSTORE, BillType.INSTORE, BillType.PAYMENT, BillType.RECEIPT, BillType.ARRIVAL, BillType.DELIVERY,
			BillType.LOADING, BillType.SEND, BillType.TRANSIT
	};
	private static String[] buttonname = {"全部审批", "返回", "单据刷新", "类型筛选"};
	
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
