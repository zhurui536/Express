package main.bussinesslogicservice.billblservice._driver;

import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.billblservice.BillBLService;
import main.bussinesslogicservice.billblservice._stub.BillBLService_Stub;
import main.vo.BillVO;
/**
 * Created By ZHR
 * 2015/10/26
 */
public class BillBLService_Driver {
	public static void main(String[] args){
		BillBLService bbls = new BillBLService_Stub();
		
		drive(bbls);
	}
	
	public static void drive(BillBLService bbls){
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
			
			if(result.getKey().equals("success")){
				bvo = (ArrayList<BillVO>) result.getValue();
				
				if(bvo.size()>0){
					vo = bbls.chooseBill(bvo.get(0).getID());
					
					System.out.println(vo.getID()+" "+vo.getBillType());
					
					bvo = bbls.back();
				}
				
				bbls.end();
			}
		}
		else{
			System.out.println(result.getKey());
		}
	}

}
