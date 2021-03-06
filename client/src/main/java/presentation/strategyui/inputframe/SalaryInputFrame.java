package presentation.strategyui.inputframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import presentation.WarningDialog;
import presentation.mainui.InputFrame;
import presentation.mainui.component.ToolButton;
import presentation.strategyui.listener.SalaryToolListener;
import util.Job;
import util.SalaryType;
import vo.SalaryVO;
import vo.StaffMessageVO;

@SuppressWarnings("serial")
public class SalaryInputFrame extends InputFrame implements ActionListener{
	private StaffMessageVO vo;
	private SalaryToolListener tl;
	
	private JTextArea salary;
	private JComboBox<String> type;
	private JButton confirm;
	private JButton cancle;
	
//	public static void main(String[] args){
//		StaffMessageVO vo = new StaffMessageVO("141250212", "朱浩然");
//		vo.institutionid = "20501242";
//		vo.job = Job.SALESOFCENTRE;
//		vo.salary = new SalaryVO(2000, SalaryType.MONTHLY);
//		
//		SalaryInputFrame test = new SalaryInputFrame(vo, null);
//		test.setVisible(true);
//	}
	
	public SalaryInputFrame(StaffMessageVO vo, SalaryToolListener tl){
		this.vo = vo;
		this.tl = tl;
		
		this.setLayout(null);
		this.setSize(430, 275);
		this.setLocation(400, 250);
		initialize(vo);
	}

	private void initialize(StaffMessageVO vo) {
		JLabel title = new JLabel("员工薪水修改");
		title.setBounds(150, 10, 130, 30);
		this.getContentPane().add(title, 0);
		
		JLabel id = new JLabel("员工id："+vo.id);
		id.setBounds(20, 50, 240, 30);
		this.getContentPane().add(id, 0);
		
		JLabel name = new JLabel("员工姓名："+vo.name);
		name.setBounds(20, 90, 180, 30);
		this.getContentPane().add(name, 0);
		
		JLabel job = new JLabel("职业："+Job.jobToString(vo.job));
		job.setBounds(210, 90, 160, 30);
		this.getContentPane().add(job, 0);
		
		JLabel sala = new JLabel("薪水类型及数额：");
		sala.setBounds(20, 130, 140, 30);
		this.getContentPane().add(sala, 0);
		
		type = new JComboBox<String>(salarytype);
		if(vo.salary.getType() == SalaryType.MONTHLY){
			type.setSelectedIndex(0);
		}
		else if(vo.salary.getType() == SalaryType.DEDUCT){
			type.setSelectedIndex(2);
		}
		else{
			type.setSelectedIndex(1);
		}
		type.setBounds(20, 170, 100, 30);
		this.getContentPane().add(type, 0);
		
		salary = new JTextArea(vo.salary.getSalary()+"");
		salary.setBounds(140, 170, 100, 30);
		this.getContentPane().add(salary, 0);
		
		confirm = new ToolButton(120, 210,"确定");
		cancle = new ToolButton(200, 210,"取消");
		confirm.setSize(60, 25);
		cancle.setSize(60, 25);
		confirm.addActionListener(this);
		cancle.addActionListener(this);
		this.getContentPane().add(confirm, 0);
		this.getContentPane().add(cancle, 0);
	}
	
	private final String[] salarytype = {"月薪", "按次", "提成"};
	private SalaryType boxToType(){
		int i = this.type.getSelectedIndex();
		if(i==0)
			return SalaryType.MONTHLY;
		else if(i==1)
			return SalaryType.ONCE;
		else
			return SalaryType.DEDUCT;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == confirm){
			StaffMessageVO vo = new StaffMessageVO();
			vo.id = this.vo.id;
			vo.institutionid = this.vo.institutionid;
			vo.job = this.vo.job;
			vo.name = this.vo.name;
			try{
				double salary = Double.parseDouble(this.salary.getText());
				vo.salary = new SalaryVO(salary, this.boxToType());
				
				boolean result = tl.getInput(vo);
				if(result){
					this.dispose();
				}
			}catch(Exception e){
				e.printStackTrace();
				new WarningDialog(null, "输入有误，请重新输入");
				this.salary.setText(vo.salary.getSalary()+"");
			}
			
		}
		if(arg0.getSource() == cancle){
			this.dispose();
		}
	}
}
