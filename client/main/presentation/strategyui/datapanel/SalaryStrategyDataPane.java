package main.presentation.strategyui.datapanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import main.bussinesslogic.strategybl.StrategySalaryBLServiceImpl;
import main.bussinesslogic.util.Job;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.SalaryType;
import main.bussinesslogicservice.strategyblservice.StrategySalaryBLService;
import main.presentation.managerui.ManagerFrame;
import main.vo.SalaryVO;

@SuppressWarnings("serial")
public class SalaryStrategyDataPane extends JPanel implements ActionListener {
	private JTextArea[] input;
	private JComboBox<String> job;
	private JComboBox<String> type;
	
	private JButton confirm;
	private JButton cancle;
	
	private ManagerFrame ui;
	private StrategySalaryBLService bl = new StrategySalaryBLServiceImpl();
	
	public SalaryStrategyDataPane(ManagerFrame ui){
		this.ui = ui;
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
		
		confirm = new JButton("纭畾");
		confirm.setBounds(70, 270, 70, 30);
		confirm.addActionListener(this);
		this.add(confirm);
		
		cancle = new JButton("鍙栨秷");
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
				ResultMessage result = bl.inputSalaryInfo(new SalaryVO(id, job, salary, this.boxToType()));
				if(result.getKey().equals("success")){
					input[1].setText("璁剧疆鎴愬姛锛�");
					ui.validate();
					ui.repaint();
				}
				else{
					input[1].setText(result.getKey());
					ui.validate();
					ui.repaint();
				}
			}catch(Exception ex){
				input[1].setText("杈撳叆鏈夎锛岃閲嶆柊杈撳叆");
			}
		}
	}
	
	private final String[] jobs ={ "蹇�掑憳", "钀ヤ笟鍘呬笟鍔″憳", "涓浆涓績涓氬姟鍛�", "涓浆涓績搴撳瓨绠＄悊浜哄憳","璐㈠姟浜哄憳","鎬荤粡鐞�","鍙告満" };
	private final String[] listname = {"钖按鍒跺畾", "鐢ㄦ埛鍚�", "鑱屼綅", "钖按", "钖按绫诲瀷"};
	private final String[] salarytype = {"鏈堣柂", "涓�娆′竴缁�", "鎻愭垚"};
	
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
