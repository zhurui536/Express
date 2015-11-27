package main.bussinesslogic.storebl;

import java.util.Calendar;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Trans;
import main.bussinesslogicservice.storeblservice.StoreBLService;
import po.UserPO;
import po.storepo.StorePlacePO;

public class StoreBLController implements StoreBLService {
	private UserPO user;
	private InStoreBL instore;
	private OutStoreBL outstore;
	private CheckBL check;
	private VerificationBL verification;
	private AdjustBL adjust;
	
	public StoreBLController(UserPO user){
		this.user = user;
	}

	@Override
	public void newInStore() {
		// TODO Auto-generated method stub
		instore = new InStoreBL(user);
	}

	@Override
	public ResultMessage addInStoreGoods(String id, StorePlacePO place,
			String destination) {
		// TODO Auto-generated method stub
		return instore.addInStoreGoods(id, place, destination);
	}

	@Override
	public ResultMessage delInStoreGoods(String id) {
		// TODO Auto-generated method stub
		return instore.delInStoreGoods(id);
	}

	@Override
	public ResultMessage endInStore(int condition) {
		// TODO Auto-generated method stub
		ResultMessage result = instore.endInStore(condition);
		instore = null;
		return result;
	}

	@Override
	public void newOutStore() {
		// TODO Auto-generated method stub
		outstore = new OutStoreBL(user);
	}

	@Override
	public ResultMessage addOutStoreGoods(String id, Trans trans,
			String Destination) {
		// TODO Auto-generated method stub
		return outstore.addOutStoreGoods(id, trans, Destination);
	}

	@Override
	public ResultMessage delOutStoreGoods(String id) {
		// TODO Auto-generated method stub
		return outstore.delOutStoreGoods(id);
	}

	@Override
	public ResultMessage endOutStore(int condition) {
		// TODO Auto-generated method stub
		outstore.endOutStore(condition);
		outstore = null;
		return null;
	}

	@Override
	public void newAdjust() {
		// TODO Auto-generated method stub
		adjust = new AdjustBL();
	}

	@Override
	public ResultMessage addAdjust(StorePlacePO start, StorePlacePO end) {
		// TODO Auto-generated method stub
		return adjust.addAdjust(start, end);
	}

	@Override
	public void endAdjust(int condition) {
		// TODO Auto-generated method stub
		adjust.endAdjust(condition);
		adjust = null;
	}

	@Override
	public void newCheck() {
		// TODO Auto-generated method stub
		check = new CheckBL();
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
		// TODO Auto-generated method stub
		return verification.verification();
	}

	@Override
	public void endVerification(int condition) {
		// TODO Auto-generated method stub
		verification.endVerification(condition);
	}

	@Override
	public ResultMessage delAdjust(int i) {
		// TODO Auto-generated method stub
		return adjust.delAdjust(i);
	}

}
