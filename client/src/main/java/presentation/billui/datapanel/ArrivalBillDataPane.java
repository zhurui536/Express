package presentation.billui.datapanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import po.logisticpo.ArrivalBillPO;
import vo.logisticvo.ArrivalBillVO;

public class ArrivalBillDataPane extends JPanel {
//	public static void main(String[] args){
//		JFrame test = new JFrame();
//		test.setLayout(null);
//		test.setBounds(400, 400, 1000, 600);
//		
//		ArrivalBillPO po = new ArrivalBillPO("栖霞区营业厅", "2015年12月13日", "141250212", "南京大学新老校区", GoodsState.COMPLETE);
//		test.add(new ArrivalBillDataPane(po));
//		
//		test.setVisible(true);
//	}
	
	public ArrivalBillDataPane(ArrivalBillPO po){
		ArrivalBillVO vo = new ArrivalBillVO(po);
		
		this.setLayout(null);
		this.setBounds(140, 100, 810, 500);
		
		this.initialize(vo);;
	}
	
	private void initialize(ArrivalBillVO vo){
		JLabel[] listname = new JLabel[5];
		for(int i=0;i<listname.length;i++){
			listname[i] = new JLabel(listnames[i]);
			listname[i].setSize(120, 40);
			this.add(listname[i]);
		}
		
		listname[0].setLocation(10, 10);
		JLabel institution = new JLabel(vo.institution);
		institution.setBounds(130, 10, 200, 40);
		this.add(institution);
		
		listname[1].setLocation(340, 10);
		JLabel date = new JLabel(vo.date);
		date.setBounds(460, 10, 200, 40);
		this.add(date);
		
		listname[2].setLocation(10, 70);
		JLabel transid = new JLabel(vo.transferBillNum);
		transid.setBounds(130, 70, 200, 40);
		this.add(transid);
		
		listname[3].setLocation(10, 130);
		JLabel startplace = new JLabel(vo.departurePlace);
		startplace.setBounds(130, 130, 200, 40);
		this.add(startplace);
		
		listname[4].setLocation(350, 130);
		JLabel state = new JLabel(vo.goodsState.name());
		state.setBounds(470, 130, 80, 40);
		this.add(state);
	}
	
	private final String[] listnames = { "录入机构", "到达日期", "中转单编号", "出发地", "货物到达状态"};
}
