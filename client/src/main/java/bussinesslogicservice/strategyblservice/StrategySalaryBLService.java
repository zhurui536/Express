package bussinesslogicservice.strategyblservice;

import util.ResultMessage;
import vo.StaffMessageVO;

/*
 * Created By Wippy
 * 2015/10/26
 */

public interface StrategySalaryBLService {
	public ResultMessage getSalary();
	
//	public ResultMessage inputSalaryInfo(StaffMessageVO vo);
	
	public ResultMessage endSalary(int condition);
	
	public ResultMessage modifySalary(StaffMessageVO vo);
}
