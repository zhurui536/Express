package presentation.strategyui.datapanel;

import bussinesslogicservice.strategyblservice.StrategySalaryBLService;
import presentation.managerui.ManagerFrame;
import util.Job;
import util.ResultMessage;
import util.SalaryType;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class SalaryStrategyDataPane extends JPanel implements ActionListener {
	private JTextArea[] input;
	private JComboBox<String> job;
	private JComboBox<String> type;
	
	private JButton confirm;
	private JButton cancle;
	
	private ManagerFrame ui;
	private StrategySalaryBLService bl;
	
	public SalaryStrategyDataPane(ManagerFrame ui){
		this.ui = ui;
		this.bl = ui.getStrategySalaryController();
		this.setBounds(140, 100, 810, 500);
		this.setLayout(null);
		this.initialize();
	}
	
	private void initialize(){
		JLabel[] list = new JLabel[5];
		
		for(int i=0;i<4;i++){
			list[i] = new JLabel(listname[i]);
			list[i].setBounds(10, 10+50*i, 80, 40);
			this.add(list[i]);
		}
		
		input = new JTextArea[2];
		input[0] = new JTextArea();
		input[0].setBounds(120, 60, 200, 40);
		this.add(input[0]);
		
		input[1] = new JTextArea();
		input[1].setBounds(120, 160, 200, 40);
		this.add(input[1]);
		
		job = new JComboBox<String>(jobs);
		job.setBounds(120, 110, 170, 40);
		this.add(job);
		
		type = new JComboBox<String>(salarytype);
		type.setBounds(120, 210, 170, 40);
		this.add(type);
		
		confirm = new JButton("确定");
		confirm.setBounds(70, 270, 70, 30);
		confirm.addActionListener(this);
		this.add(confirm);
		
		cancle = new JButton("取消");
		cancle.setBounds(160, 270, 70, 30);
		cancle.addActionListener(this);
		this.add(cancle);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancle){
			ui.paintdata(null);
		}
		if(e.getSource() == confirm){
			Job job = this.boxToJob();
			String id = this.input[0].getText();
			try{
				double salary = Double.parseDouble(input[1].getText());
				ResultMessage result = null;
				if(result.getKey().equals("success")){
					input[1].setText("设置成功");
					ui.validate();
					ui.repaint();
				}
				else{
					input[1].setText(result.getKey());
					ui.validate();
					ui.repaint();
				}
			}catch(Exception ex){
				input[1].setText("网络错误");
			}
		}
	}
	
	private final String[] jobs ={ "快递员", "营业厅业务员", "中转中心业务员", "库存管理员","财务人员","总经理","司机" };
	private final String[] listname = {"薪水策略制定：", "员工编号：", "职业：", "薪水：", "薪水类型："};
	private final String[] salarytype = {"月薪", "按次", "提成"};
	
	private Job boxToJob(){
		int i = this.job.getSelectedIndex();
		if(i == 0)
			return Job.COURIER;
		else if(i == 1)
			return Job.SALESOFOFFICE;
		else if(i==2)
			return Job.SALESOFCENTRE;
		else if(i==3)
			return Job.STOCKMAN;
		else if(i==4)
			return Job.FINANCEMAN;
		else if(i==5)
			return Job.MANAGER;
		else
			return Job.DRIVER;
	}
	
	private SalaryType boxToType(){
		int i = this.type.getSelectedIndex();
		if(i==0)
			return SalaryType.MONTHLY;
		else if(i==1)
			return SalaryType.ONCE;
		else
			return SalaryType.DEDUCT;
	}
}
