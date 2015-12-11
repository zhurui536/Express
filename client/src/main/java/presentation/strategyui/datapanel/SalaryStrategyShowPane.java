package presentation.strategyui.datapanel;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

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
		JTable table = new JTable();
	}
	
	private Object[][] cellData(){
		Object[][] celldata = new Object[vos.size()][6];
		
		for(int i=0;i<vos.size();i++){
			StaffMessageVO vo = vos.get(i);
			
			celldata[i][0] = vo.id;
			celldata[i][1] = vo.name;
			celldata[i][2] = Job.jobToString(vo.job);
			celldata[i][3] = vo.salary.getSalary();
			celldata[i][4] = SalaryType.salaryToString(vo.salary.getType());
			
			JButton modify = new JButton("修改");
			
		}
		
		return null;
	}
	
	private final String[] header = {"员工id", "员工姓名", "员工职位", "员工薪水", "薪水类型", "修改"};
}
