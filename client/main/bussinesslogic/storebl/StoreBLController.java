package main.bussinesslogic.storebl;

import java.util.Calendar;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Trans;
import main.bussinesslogicservice.storeblservice.StoreBLService;
import po.UserPO;
import po.storepo.StorePlacePO;

public class StoreBLController implements StoreBLService {
	private UserPO user;
	
	//分别为库存方面的五个用例，由这个类统一控制
	private InStoreBL instore;
	private OutStoreBL outstore;
	private CheckBL check;
	private VerificationBL verification;
	private AdjustBL adjust;
	
	//表示目前处于的状态，0代表空闲，1代表入库，2代表出库，3代表查看，4代表盘点，5代表调整，1-5的状态必须先回到0才能变成新的1-5
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
	public ResultMessage addInStoreGoods(String id, StorePlacePO place,
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
		instore = null;
		condition = 0;
		
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
			String Destination) {
		return outstore.addOutStoreGoods(id, trans, Destination);
	}

	@Override
	public ResultMessage delOutStoreGoods(String id) {
		return outstore.delOutStoreGoods(id);
	}

	@Override
	public ResultMessage endOutStore(int condition) {
		outstore.endOutStore(condition);
		outstore = null;
		condition = 0;
		
		return null;
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
	public ResultMessage addAdjust(StorePlacePO start, StorePlacePO end) {
		return adjust.addAdjust(start, end);
	}

	@Override
	public ResultMessage endAdjust(int condition) {
		ResultMessage result = adjust.endAdjust(condition);
		adjust = null;
		condition = 0;
		
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
		// TODO Auto-generated method stub
		return check.check(start, end);
	}

	@Override
	public void endCheck() {
		check = null;
		
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
		condition = 0;
		return verification.endVerification(condition);
	}

	@Override
	public ResultMessage delAdjust(int i) {
		
		return adjust.delAdjust(i);
	}

}
