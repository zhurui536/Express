package presentation.infoui.datapanel;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import util.Job;
import util.MyJTable;
import util.SalaryType;
import vo.StaffMessageVO;

public class StaffMessageDataPane extends JPanel {
	
	public StaffMessageDataPane(ArrayList<StaffMessageVO> vos){
		this.setBounds(140, 100, 810, 500);
		this.setLayout(null);
		
		this.initialize(vos);
	}

	private void initialize(ArrayList<StaffMessageVO> vos) {
		Object[][] rowdata = new Object[vos.size()][6];
		
		for(int i=0;i<vos.size();i++){
			StaffMessageVO vo = vos.get(i);
			rowdata[i][0] = vo.name;
			rowdata[i][1] = vo.id;
			rowdata[i][2] = vo.institutionid;
			rowdata[i][3] = Job.jobToString(vo.job);
			rowdata[i][4] = SalaryType.salaryToString(vo.salary.getType());
			rowdata[i][5] = vo.salary.getSalary()+"";
		}
		
		MyJTable table = new MyJTable(rowdata, header);
		table.setWidth(new int[]{100, 160, 160, 120, 60, 100});
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(0, 0, 810, 500);
		
		this.add(scroller);
	}
	
	private final String[] header = {"姓名", "员工编号", "机构编号", "职业", "薪水类型", "薪水"};
}
