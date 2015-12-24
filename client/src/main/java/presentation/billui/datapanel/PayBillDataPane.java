package presentation.billui.datapanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import po.financepo.PayBillPO;
import util.Job;
import vo.StaffMessageVO;
import vo.financevo.BankAccountVO;
import vo.financevo.PayBillVO;
//
public class PayBillDataPane extends JPanel {
//
////	public static void main(String[] args){
////		JFrame test = new JFrame();
////		test.setBounds(400, 400, 1000, 600);
////
////		StaffMessagePO staff = new StaffMessagePO("141250212", "朱浩然", "10001", Job.DRIVER, SalaryType.MONTHLY, 1333.2);
////
////		PayBillPO po = new PayBillPO(new Time(), new BigDecimal(1.22), staff, new BankAccountPO("朱浩然", new BigDecimal(1.08), "141250212"), "141250211", PayItem.RENT, "测试用例");
////
////		JPanel data = new PayBillDataPane(po);
////		test.getContentPane().add(data);
////
////		test.setVisible(true);
////	}
//
	public PayBillDataPane(PayBillPO po){
//		PayBillVO vo = new PayBillVO(po);
//		this.setLayout(null);
//		this.setBounds(140, 100, 810, 500);
//
//		this.initialize(vo, po.getUserID());
	}
//
//	private void initialize(PayBillVO vo, String writerid){
//		JLabel[] itemname = new JLabel[8];
//		for(int i=0;i<itemname.length;i++){
//			itemname[i] = new JLabel(itemnames[i]);
//			itemname[i].setSize(100, 40);
//			this.add(itemname[i]);
//		}
//
//		itemname[0].setLocation(20, 10);
//		JLabel id = new JLabel(vo.id);
//		id.setBounds(140, 10, 240, 40);
//		this.add(id);
//
//		itemname[1].setLocation(400, 10);
//		JLabel writer = new JLabel(writerid);
//		writer.setBounds(520, 10, 240, 40);
//		this.add(writer);
//
//		itemname[2].setLocation(20, 70);
//		JLabel time = new JLabel(vo.time.toString());
//		time.setBounds(140, 70, 150, 40);
//		this.add(time);
//
//		itemname[3].setLocation(400, 70);
//		JLabel payitem = new JLabel(vo.item.getName());
//		payitem.setBounds(520, 70, 100, 40);
//		this.add(payitem);
//
//		itemname[4].setLocation(20, 130);
//		JLabel money = new JLabel(vo.money + "");
//		money.setBounds(140, 130, 240, 40);
//		this.add(money);
//
//		itemname[5].setLocation(20, 190);
//		JPanel payerinfo = this.payer(vo.staffMessageVO);
//		this.add(payerinfo);
//
//		itemname[6].setLocation(20, 310);
//		JPanel bankinfo = this.bankinfo(vo.bankAccountVO);
//		this.add(bankinfo);
//
//		itemname[7].setLocation(20, 430);
//		JLabel tip = new JLabel(vo.remark);
//		tip.setBounds(140, 430, 250, 40);
//		this.add(tip);
//	}
//
//	private JPanel payer(StaffMessageVO vo){
//		JPanel payerinfo = new JPanel();
//		payerinfo.setBounds(140, 190, 670, 100);
//		payerinfo.setLayout(null);
//
//		JLabel[] listname = new JLabel[3];
//		listname[0] = new JLabel("付款人id");
//		listname[1] = new JLabel("付款人姓名");
//		listname[2] = new JLabel("职位");
//
//		for(int i=0;i<listname.length;i++){
//			listname[i].setSize(100, 40);
//			payerinfo.add(listname[i]);
//		}
//
//		listname[0].setLocation(20, 0);
//		JLabel id = new JLabel(vo.id);
//		id.setBounds(140, 0, 200, 40);
//		payerinfo.add(id);
//
//		listname[1].setLocation(20, 60);
//		JLabel name = new JLabel(vo.name);
//		name.setBounds(140, 60, 200, 40);
//		payerinfo.add(name);
//
//		listname[2].setLocation(370, 60);
//		JLabel job = new JLabel(Job.jobToString(vo.job));
//		job.setBounds(500, 60, 140, 40);
//		payerinfo.add(job);
//
//		return payerinfo;
//	}
//
//	private JPanel bankinfo(BankAccountVO vo){
//		JPanel bankinfo = new JPanel();
//		bankinfo.setBounds(120, 310, 670, 100);
//		bankinfo.setLayout(null);
//
//		JLabel[] listname = new JLabel[3];
//		listname[0] = new JLabel("账户名称");
//		listname[1] = new JLabel("账户账号");
//		listname[2] = new JLabel("账户余额");
//
//		for(int i=0;i<listname.length;i++){
//			listname[i].setSize(80, 40);
//			bankinfo.add(listname[i]);
//		}
//
//		listname[0].setLocation(20, 0);
//		JLabel id = new JLabel(vo.name);
//		id.setBounds(100, 0, 200, 40);
//		bankinfo.add(id);
//
//		listname[1].setLocation(20, 60);
//		JLabel name = new JLabel(vo.id);
//		name.setBounds(100, 60, 200, 40);
//		bankinfo.add(name);
//
//		listname[2].setLocation(330, 60);
//		JLabel balance = new JLabel(vo.balance+"");
//		balance.setBounds(410, 60, 140, 40);
//		bankinfo.add(balance);
//
//		return bankinfo;
//	}
//
//	private final String[] itemnames = {"付款单编号：", "单据编写者：", "付款时间：", "付款条目：", "付款金额：", "付款人信息：", "账户信息：", "备注："};
}
