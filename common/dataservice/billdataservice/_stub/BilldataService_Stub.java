package dataservice.billdataservice._stub;

import java.util.ArrayList;

import dataservice.billdataservice.BilldataService;
import main.bussinesslogic.util.BillType;
import main.bussinesslogic.util.ResultMessage;
/*
 * Created By ZHR
 * 2015/10/26
 */
public class BilldataService_Stub implements BilldataService {

	@Override
	public ResultMessage approve(String id, BillType type) {
		// TODO Auto-generated method stub
		System.out.println("approve the bill of "+id+"!");
		
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage approves(ArrayList<String> ids, ArrayList<BillType> types) {
		// TODO Auto-generated method stub
		System.out.println("approve bills:");
		for(int i=0;i<ids.size();i++){
			System.out.println(ids.get(i));
		}
		
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage find(String id, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage getBills() {
		// TODO Auto-generated method stub
		return null;
	}

}
