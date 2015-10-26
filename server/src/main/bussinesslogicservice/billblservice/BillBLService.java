package main.bussinesslogicservice.billblservice;

import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.vo.BillVO;

/**
 * Created By ZHR
 * 2015/10/26
 */

public interface BillBLService {
	//获得所有未审批的单据
	public ResultMessage getBills();
	
	//返回被选择的单据的详细信息
	public BillVO chooseBill(String id);
	
	//从上一个方法返回时调用的方法
	public ArrayList<BillVO> back();
	
	//审批单个单据
	public ResultMessage approve(String id);
	
	//批量审批单据
	public ResultMessage approves(ArrayList<String> ids);
	
	//结束审批
	public void end();
}
