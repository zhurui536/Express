package main.bussinesslogic.billbl;

import java.util.ArrayList;

import dataservice.billdataservice.BilldataService;
import po.UserPO;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogicservice.billblservice.BillBLService;
import main.vo.BillVO;

public class BillBLController implements BillBLService{
	UserPO user;
	BilldataService dataservice;
	
	public BillBLController(UserPO user){
		this.user = user;
		
	}

	@Override
	public ResultMessage getBills() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BillVO chooseBill(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BillVO> back() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage approve(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage approves(ArrayList<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

}
