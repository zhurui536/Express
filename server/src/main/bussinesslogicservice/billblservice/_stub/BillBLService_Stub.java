package main.bussinesslogicservice.billblservice._stub;

import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.billblservice.BillBLService;
import main.vo.BillVO;

public class BillBLService_Stub implements BillBLService {

	@Override
	public ResultMessage getBills() {
		// TODO Auto-generated method stub
		System.out.println("Asking for bills!");
		ArrayList<BillVO> bvo = new ArrayList<BillVO>();
		
		bvo.add(new BillVO("10010", null));
		return new ResultMessage("success", bvo);
	}

	@Override
	public BillVO chooseBill(String id) {
		// TODO Auto-generated method stub
		System.out.println("Asking for information of a chosed bill:"+ id + "!");
		
		return new BillVO("10010", null);
	}

	@Override
	public ArrayList<BillVO> back() {
		// TODO Auto-generated method stub
		System.out.println("Return for bill list!");
		ArrayList<BillVO> bvo = new ArrayList<BillVO>();
		
		bvo.add(new BillVO("10010", null));
		bvo.add(new BillVO("10086", null));
		return bvo;
	}

	@Override
	public ResultMessage approve(String id) {
		// TODO Auto-generated method stub
		if(id.equals("10010")||id.equals("10086")){
			return new ResultMessage("success", back());
		}
		else{
			return new ResultMessage("fail", back());
		}
	}

	@Override
	public ResultMessage approves(ArrayList<String> ids) {
		// TODO Auto-generated method stub
		System.out.println("Approve severval bills!");
		String id;
		
		for(int i=0;i<ids.size();i++){
			id = ids.get(i);
			
			approve(id);
		}
		
		return new ResultMessage("success", null);
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		System.out.println("End the bill approve task!");
	}

}
