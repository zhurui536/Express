package main.bussinesslogicservice.strategyblservice._stub;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.strategyblservice.StrategySalaryBLService;
import main.vo.SalaryVO;



/*
 * Created By Wippy
 * 2015/10/26
 */


public class StrategySalaryBLService_Stub implements StrategySalaryBLService{

	public void newSalary(){
		System.out.println("Ready to draft salary strategy!");
	}
	
	public ResultMessage inputSalaryInfo(long id, String Post,int salary){
		if(id == 1111111111){
			return new ResultMessage("success", null);
		}
		else{
			return new ResultMessage("cannot find", null);
		}
	}
	
	public void endSalary(){
		System.out.println("The salary strategy was drafted!");
	}

	@Override
	public ResultMessage inputSalaryInfo(SalaryVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
}
