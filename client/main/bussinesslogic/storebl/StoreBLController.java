package main.bussinesslogic.storebl;

import java.util.Calendar;

import po.UserPO;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Trans;
import main.bussinesslogicservice.storeblservice.StoreBLService;
import main.vo.storevo.StorePlaceVO;

public class StoreBLController implements StoreBLService {
	//以下为处理5种用例所用的逻辑处理对象
	private AdjustBL adjust;
	private CheckBL check;
	private InStoreBL instore;
	private OutStoreBL outstore;
	private VerificationBL verification;
	
	//包含了创建该事件的用户的信息
	private UserPO user;
	
	//表示当前的状态，0代表空闲
	private int condition;
	
	public StoreBLController(UserPO user){
		this.user = user;
		this.condition = 0;
	}

	@Override
	public ResultMessage newInStore() {
		if(condition == 0){
			instore = new InStoreBL(user);
			condition = 1;
			return instore.newInStore();
		}
		else{
			return new ResultMessage("busy", null);
		}
	}

	@Override
	public ResultMessage addInStoreGoods(String id, StorePlaceVO place,
			String destination) {
		return instore.addInStoreGoods(id, place, destination);
	}

	@Override
	public ResultMessage delInStoreGoods(String id) {
		return instore.delInStoreGoods(id);
	}

	@Override
	public ResultMessage endInStore(int condition) {
		ResultMessage result = instore.endInStore(condition);
		if(result.getKey().equals("success")){
			instore = null;
			this.condition = 0;
		}
		return result;
	}

	@Override
	public ResultMessage newOutStore() {
		if(condition == 0){
			outstore = new OutStoreBL(user);
			condition = 2;
			return outstore.newOutStore();
		}
		else{
			return new ResultMessage("busy", null);
		}
	}

	@Override
	public ResultMessage addOutStoreGoods(String id, Trans trans,
			String Destination, String billid) {
		return outstore.addOutStoreGoods(id, trans, Destination, billid);
	}

	@Override
	public ResultMessage delOutStoreGoods(String id) {
		return outstore.delOutStoreGoods(id);
	}

	@Override
	public ResultMessage endOutStore(int condition) {
		ResultMessage result = outstore.endOutStore(condition);
		if(result.getKey().equals("success")){
			outstore = null;
			this.condition = 0;
		}
		return result;
	}

	@Override
	public ResultMessage newAdjust() {
		if(condition == 0){
			adjust = new AdjustBL(user);
			condition = 5;
			return adjust.newAdjust();
		}
		else{
			return new ResultMessage("busy", null);
		}
	}

	@Override
	public ResultMessage addAdjust(StorePlaceVO start, StorePlaceVO end) {
		return adjust.addAdjust(start, end);
	}

	@Override
	public ResultMessage delAdjust(int i) {
		return adjust.delAdjust(i);
	}

	@Override
	public ResultMessage endAdjust(int condition) {
		if(adjust == null){
			System.out.println("adjust is null!");
		}
		ResultMessage result = adjust.endAdjust(condition);
		if(result.getKey().equals("success")){
			this.condition = 0;
			adjust = null;
		}
		return result;
	}

	@Override
	public ResultMessage newCheck() {
		if(condition == 0){
			check = new CheckBL();
			condition = 3;
			return check.newCheck();
		}
		else{
			return new ResultMessage("busy", null);
		}
	}

	@Override
	public ResultMessage check(Calendar start, Calendar end) {
		return check.check(start, end);
	}

	@Override
	public void endCheck() {
		check.endCheck();
		check = null;
		condition = 0;
	}

	@Override
	public ResultMessage verification() {
		if(condition == 0){
			verification = new VerificationBL(user);
			condition = 4;
			return verification.verification();
		}
		else{
			return new ResultMessage("busy", null);
		}
	}

	@Override
	public ResultMessage endVerification(int condition) {
		ResultMessage result = verification.endVerification(condition);
		if(result.getKey().equals("success")){
			verification = null;
			this.condition = 0;
		}
		return result;
	}

}
