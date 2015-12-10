package dataservice.billdataservice._stub;

import dataservice.billdataservice.BilldataService;
import po.BillPO;
import util.BillType;
import util.ResultMessage;

import java.util.ArrayList;
/*
 * Created By ZHR
 * 2015/10/26
 */
public class BilldataService_Stub implements BilldataService {

	public ResultMessage approve(String id, BillType type) {
		// TODO Auto-generated method stub
		System.out.println("approve the bill of "+id+"!");
		
		return new ResultMessage("success", null);
	}

	public ResultMessage approves(ArrayList<String> ids, ArrayList<BillType> types) {
		// TODO Auto-generated method stub
		System.out.println("approve bills:");
		for(int i=0;i<ids.size();i++){
			System.out.println(ids.get(i));
		}
		
		return new ResultMessage("success", null);
	}

	public ResultMessage find(String id, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage getBills() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage getBills(BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveBills(ArrayList<? extends BillPO> bills, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

}
