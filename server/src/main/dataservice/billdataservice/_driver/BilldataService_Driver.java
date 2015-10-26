package main.dataservice.billdataservice._driver;

import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.dataservice.billdataservice.BilldataService;
import main.dataservice.billdataservice._stub.BilldataService_Stub;
import main.po.BillPO;

public class BilldataService_Driver {
	public static void main(String[] args){
		BilldataService bds = new BilldataService_Stub();
		
		drive(bds);
	}

	public static void drive(BilldataService bds){
		ResultMessage result = null;
		BillPO bpo = null;
		ArrayList<BillPO> abpo = new ArrayList<BillPO>();
		
		bpo = bds.find("10010");
		
		abpo = bds.getBills();
		System.out.println("Bills received:");
		for(int i=0;i<abpo.size();i++){
			System.out.println(abpo.get(i).getID());
		}
		
		result = bds.approve("10010");
		System.out.println(result.getKey());
		
		ArrayList<String> as = new ArrayList<String>();
		as.add("10086");
		as.add("12580");
	}
}
