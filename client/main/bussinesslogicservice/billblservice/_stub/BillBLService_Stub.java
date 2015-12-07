package main.bussinesslogicservice.billblservice._stub;

import java.util.ArrayList;

import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.billblservice.BillBLService;
import main.vo.BillVO;
/**
 * Created By ZHR
 * 2015/10/26
 */
public class BillBLService_Stub implements BillBLService {

	@Override
	public ResultMessage getBills() {
		// TODO Auto-generated method stub
		System.out.println("Asking for bills!");
		ArrayList<BillVO> bvo = new ArrayList<BillVO>();
		
		bvo.add(new BillVO("10010", null, "10086"));
		return new ResultMessage("success", bvo);
	}

	@Override
	public ResultMessage chooseBill(String id, BillType type) {
		// TODO Auto-generated method stub
		System.out.println("Asking for information of a chosed bill:"+ id + "!");
		
		return null;
	}

	@Override
	public ResultMessage approve(String id, BillType type) {
		// TODO Auto-generated method stub
		if(id.equals("10010")||id.equals("10086")){
			return new ResultMessage("success", back());
		}
		else{
			return new ResultMessage("fail", back());
		}
	}

	private Object back() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage approves(ArrayList<String> ids, ArrayList<BillType> types) {
		// TODO Auto-generated method stub
		System.out.println("Approve severval bills!");
		String id;
		
		for(int i=0;i<ids.size();i++){
			id = ids.get(i);
			
			approve(id, null);
		}
		
		return new ResultMessage("success", null);
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		System.out.println("End the bill approve task!");
	}

}
