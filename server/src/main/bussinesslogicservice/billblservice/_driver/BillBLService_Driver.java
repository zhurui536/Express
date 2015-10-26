package main.bussinesslogicservice.billblservice._driver;

import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.billblservice.BillBLService;
import main.vo.BillVO;
/**
 * Created By ZHR
 * 2015/10/26
 */
public class BillBLService_Driver {
	public void drive(BillBLService bbls){
		ResultMessage result = null;
		
		result = bbls.getBills();
		ArrayList<BillVO> bvo = (ArrayList<BillVO>) result.getValue();
		BillVO vo = null;
		
		if(result.getKey().equals("success")){
			for(int i=0;i<bvo.size();i++){
				vo = bvo.get(i);
				System.out.println(vo.getID());
			}
			
			result = bbls.approve(vo.getID());
			
		}
		else{
			System.out.println(result.getKey());
		}
	}

}
