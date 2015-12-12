package presentation.strategyui.datapanel;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.Job;
import util.SalaryType;
import vo.StaffMessageVO;

public class SalaryStrategyShowPane extends JPanel {
	private ArrayList<StaffMessageVO> vos;
	private ArrayList<JButton> modify;
	
	public SalaryStrategyShowPane(ArrayList<StaffMessageVO> vos){
		this.vos = vos;
		modify = new ArrayList<JButton>();
		this.setBounds(140, 100, 810, 500);
		this.setLayout(null);
		this.initialize();
	}
	
	private void initialize(){
		JPanel header = this.makeheader();
		this.add(header);
		
		for(int i=0;i<vos.size();i++){
			JPanel item = this.makeItem(vos.get(i));
			item.setLocation(0, 40*i+40);
			this.add(item);
		}
	}
	
	private JPanel makeheader(){
		JPanel list = new JPanel();
		list.setSize(810, 40);
		list.setLocation(0, 0);
		list.setLayout(null);
		
		JLabel staffid = new JLabel(header[0]);
		staffid.setBounds(10, 0, 120, 40);
		list.add(staffid);
		
		JLabel name = new JLabel(header[1]);
		name.setBounds(130, 0, 120, 40);
		list.add(name);
		
		JLabel job = new JLabel(header[2]);
		job.setBounds(260, 0, 100, 40);
		list.add(job);
		
		JLabel salary = new JLabel(header[3]);
		salary.setBounds(380, 0, 80, 40);
		list.add(salary);
		
		JLabel salarytype = new JLabel(header[4]);
		salarytype.setBounds(480, 0, 60, 40);
		list.add(salarytype);
		
		return list;
	}
	
	private JPanel makeItem(StaffMessageVO vo){
		JPanel item = new JPanel();
		item.setSize(810, 40);
		item.setLayout(null);
		
		JLabel staffid = new JLabel(vo.id);
		staffid.setBounds(10, 0, 120, 40);
		item.add(staffid);
		
		JLabel name = new JLabel(vo.name);
		name.setBounds(130, 0, 120, 40);
		item.add(name);
		
		JLabel job = new JLabel(Job.jobToString(vo.job));
		job.setBounds(260, 0, 100, 40);
		item.add(job);
		
		JLabel salary = new JLabel(vo.salary.getSalary()+"");
		salary.setBounds(380, 0, 80, 40);
		item.add(salary);
		
		JLabel salarytype = new JLabel(SalaryType.salaryToString(vo.salary.getType()));
		salarytype.setBounds(480, 0, 60, 40);
		item.add(salarytype);
		
		JButton modify = new JButton();
		modify.setBounds(560, 5, 50, 30);
		this.modify.add(modify);
		item.add(modify);
		
		return item;
	}
	
	private final String[] header = {"员工id", "员工姓名", "员工职位", "员工薪水", "薪水类型", "修改"};
}
