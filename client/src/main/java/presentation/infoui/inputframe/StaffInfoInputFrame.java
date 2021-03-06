package presentation.infoui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import presentation.WarningDialog;
import presentation.infoui.listener.StaffInfoToolListener;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import util.Job;
import util.SalaryType;
import vo.SalaryVO;
import vo.StaffMessageVO;

@SuppressWarnings("serial")
public class StaffInfoInputFrame extends InputFrame implements ActionListener{
	//表示窗口的用途，0代表增加，1代表修改
	private int condition;
	
	private StaffInfoToolListener tl;
	
	private JTextArea[] input;
	private JComboBox<String> type;
	private JComboBox<String> job;
	private JButton confirm;
	private JButton cancle;
	
//	public static void main(String[] args){
//		StaffMessageVO vo = new StaffMessageVO("141250212", "朱浩然");
//		vo.institutionid = "20501242";
//		vo.job = Job.SALESOFCENTRE;
//		vo.salary = new SalaryVO(2000, SalaryType.MONTHLY);
//		
//		StaffInfoInputFrame test = new StaffInfoInputFrame(null, vo);
//		test.setVisible(true);
//	}
	
	public StaffInfoInputFrame(StaffInfoToolListener tl){
		this.condition = 0;
		this.tl = tl;
		
		this.setLayout(null);
		this.setSize(430, 275);
		this.setLocation(400, 250);
		this.initialize();
	}
	
	public StaffInfoInputFrame(StaffInfoToolListener tl, StaffMessageVO vo){
		this.condition = 1;
		this.tl = tl;
		
		this.setLayout(null);
		this.setSize(430, 275);
		this.setLocation(400, 250);
		this.initialize(vo);
	}
	
	private void initialize(StaffMessageVO vo) {
		JLabel title = new JLabel("员工信息修改");
		title.setBounds(150, 10, 130, 30);
		this.getContentPane().add(title, 0);
		
		this.input = new JTextArea[4];
		
		
		JLabel id = new JLabel("员工id：");
		id.setBounds(20, 50, 70, 30);
		this.getContentPane().add(id, 0);
		input[0] = new JTextArea(vo.id);
		input[0].setBounds(105, 50, 100, 30);
		input[0].setEditable(false);
		this.getContentPane().add(input[0], 0);
		
		JLabel institution = new JLabel("机构id：");
		institution.setBounds(210, 50, 70, 30);
		this.getContentPane().add(institution, 0);
		input[1] = new JTextArea(vo.institutionid);
		input[1].setBounds(285, 50, 100, 30);
		this.getContentPane().add(input[1], 0);
		
		
		JLabel name = new JLabel("员工姓名：");
		name.setBounds(20, 90, 100, 30);
		this.getContentPane().add(name, 0);
		input[2] = new JTextArea(vo.name);
		input[2].setBounds(105, 90, 80, 30);
		this.getContentPane().add(input[2], 0);
		
		
		JLabel job = new JLabel("职业：");
		job.setBounds(210, 90, 70, 30);
		this.getContentPane().add(job, 0);
		this.job = new JComboBox<String>(this.jobstring);
		for(int i=0;i<this.jobs.length;i++){
			if(vo.job == jobs[i]){
				this.job.setSelectedIndex(i);
				break;
			}
		}
		this.job.setBounds(285, 90, 120, 30);
		this.getContentPane().add(this.job, 0);
		
		
		JLabel sala = new JLabel("薪水类型及数额：");
		sala.setBounds(20, 130, 140, 30);
		this.getContentPane().add(sala, 0);
		
		type = new JComboBox<String>(salarytype);
		type.setBounds(20, 170, 100, 30);
		for(int i=0;i<this.salaryType.length;i++){
			if(vo.salary.getType() == salaryType[i]){
				type.setSelectedIndex(i);
				break;
			}
		}
		this.getContentPane().add(type, 0);
		
		input[3] = new JTextArea(vo.salary.getSalary()+"");
		input[3].setBounds(140, 170, 100, 30);
		this.getContentPane().add(input[3], 0);
		
		confirm = new ToolButton(120, 210, "确定");
		cancle = new ToolButton(200, 210, "取消");
		confirm.setSize(60, 25);
		cancle.setSize(60, 25);
		confirm.addActionListener(this);
		cancle.addActionListener(this);
		this.getContentPane().add(confirm, 0);
		this.getContentPane().add(cancle, 0);
	}
	
	private void initialize() {
		JLabel title = new JLabel("员工信息输入");
		title.setBounds(150, 10, 130, 30);
		this.getContentPane().add(title, 0);
		
		this.input = new JTextArea[4];
		
		
		JLabel id = new JLabel("员工id：");
		id.setBounds(20, 50, 70, 30);
		this.getContentPane().add(id, 0);
		input[0] = new JTextArea();
		input[0].setBounds(105, 50, 100, 30);
		this.getContentPane().add(input[0], 0);
		
		JLabel institution = new JLabel("机构id");
		institution.setBounds(210, 50, 90, 30);
		this.getContentPane().add(institution, 0);
		input[1] = new JTextArea();
		input[1].setBounds(315, 50, 100, 30);
		this.getContentPane().add(input[1], 0);
		
		
		JLabel name = new JLabel("员工姓名：");
		name.setBounds(20, 90, 100, 30);
		this.getContentPane().add(name, 0);
		input[2] = new JTextArea();
		input[2].setBounds(125, 90, 80, 30);
		this.getContentPane().add(input[2], 0);
		
		
		JLabel job = new JLabel("职业：");
		job.setBounds(210, 90, 70, 30);
		this.getContentPane().add(job, 0);
		this.job = new JComboBox<String>(this.jobstring);
		this.job.setBounds(285, 90, 120, 30);
		this.getContentPane().add(this.job, 0);
		
		
		JLabel sala = new JLabel("薪水类型及数额：");
		sala.setBounds(20, 130, 140, 30);
		this.getContentPane().add(sala, 0);
		
		type = new JComboBox<String>(salarytype);
		type.setBounds(20, 170, 100, 30);
		this.getContentPane().add(type, 0);
		
		input[3] = new JTextArea();
		input[3].setBounds(140, 170, 100, 30);
		this.getContentPane().add(input[3], 0);
		
		confirm = new JButton("确定");
		cancle = new JButton("取消");
		confirm.setSize(60, 25);
		cancle.setSize(60, 25);
		confirm.setLocation(120, 210);
		cancle.setLocation(200, 210);
		confirm.addActionListener(this);
		cancle.addActionListener(this);
		this.getContentPane().add(confirm, 0);
		this.getContentPane().add(cancle, 0);
	}
	
	private final String[] salarytype = {"月薪", "按次", "提成"};
	private final SalaryType[] salaryType = {SalaryType.MONTHLY, SalaryType.ONCE, SalaryType.DEDUCT};
	private final Job[] jobs = {Job.ADMIN, Job.COURIER, Job.DRIVER, Job.FINANCEMAN, Job.MANAGER, Job.SALESOFCENTRE, Job.SALESOFOFFICE, Job.STOCKMAN};
	private final String[] jobstring = {"系统管理员", "快递员", "司机", "财务人员", "总经理", "中转中心业务员", "营业厅业务员", "库存管理员"};

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == confirm){
			StaffMessageVO vo = new StaffMessageVO();
			vo.id = input[0].getText();
			vo.institutionid = input[1].getText();
			vo.job = jobs[this.job.getSelectedIndex()];
			vo.name = input[2].getText();
			try{
				double salary = Double.parseDouble(this.input[3].getText());
				vo.salary = new SalaryVO(salary, this.salaryType[type.getSelectedIndex()]);
				
				boolean result = tl.getInput(vo, condition);
				if(result){
					this.dispose();
				}
			}catch(Exception e){
				e.printStackTrace();
				new WarningDialog(null, "薪水输入有误，请重新输入");
				this.input[3].setText("");
			}
			
		}
		if(arg0.getSource() == cancle){
			this.dispose();
		}
	}
}
