package dataservice.billdataservice._stub;

import java.util.ArrayList;

import dataservice.billdataservice.BilldataService;
import main.bussinesslogic.util.ResultMessage;
import po.BillPO;
/*
 * Created By ZHR
 * 2015/10/26
 */
public class BilldataService_Stub implements BilldataService {

	@Override
	public BillPO find(String id) {
		// TODO Auto-generated method stub
		System.out.println("asking for bills of "+id+"!");
		
		return new BillPO(id, null, "10010");
	}

	@Override
	public ResultMessage approve(String id) {
		// TODO Auto-generated method stub
		System.out.println("approve the bill of "+id+"!");
		
		return new ResultMessage("success", null);
	}

	@Override
	public ArrayList<BillPO> getBills() {
		// TODO Auto-generated method stub
		System.out.println("Asking for all bills!");
		
		ArrayList<BillPO> bpo = new ArrayList<BillPO>();
		bpo.add(new BillPO("10086", null, "10010"));
		bpo.add(new BillPO("10010", null, "12135"));
		
		return bpo;
	}

	@Override
	public ResultMessage approves(ArrayList<String> ids) {
		// TODO Auto-generated method stub
		System.out.println("approve bills:");
		for(int i=0;i<ids.size();i++){
			System.out.println(ids.get(i));
		}
		
		return new ResultMessage("success", null);
	}

}