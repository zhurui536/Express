package main.bussinesslogic.storebl;

import java.util.Calendar;

import test.mockObject.mockstoreobject.MockStorePlacePO;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Trans;
import main.bussinesslogicservice.storeblservice.StoreBLService;
import main.po.storepo.StorePlacePO;

public class StoreBLController implements StoreBLService {

	@Override
	public void newInStore() {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage addInStoreGoods(String id, StorePlacePO place,
			String destination) {
		// TODO Auto-generated method stub
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage delInStoreGoods(String id) {
		// TODO Auto-generated method stub
		return new ResultMessage("success", null);
	}

	@Override
	public void endIntStore(int condition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void newOutStore() {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage addOutStoreGoods(String id, Trans trans,
			String Destination) {
		// TODO Auto-generated method stub
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage delOutStoreGoods(String id) {
		// TODO Auto-generated method stub
		return new ResultMessage("success", null);
	}

	@Override
	public void endOutStore(int condition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void newAdjust() {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage addAdjust(StorePlacePO start, StorePlacePO end) {
		// TODO Auto-generated method stub
		return new ResultMessage("success", null);
	}

	@Override
	public void endAdjust(int condition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void newCheck() {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage check(Calendar start, Calendar end) {
		// TODO Auto-generated method stub
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage verification() {
		// TODO Auto-generated method stub
		return new ResultMessage("success", null);
	}

	@Override
	public void endVerification(int condition) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage addInStoreGoods(String id, MockStorePlacePO place,
			String destination) {
		// TODO Auto-generated method stub
		return new ResultMessage("success", null);
	}

	@Override
	public ResultMessage addAdjust(MockStorePlacePO start, MockStorePlacePO end) {
		// TODO Auto-generated method stub
		return new ResultMessage("success", null);
	}

}
