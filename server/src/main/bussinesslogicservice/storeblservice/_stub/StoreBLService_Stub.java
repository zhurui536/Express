package main.bussinesslogicservice.storeblservice._stub;

import java.sql.Time;
import java.util.ArrayList;

import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Trans;
import main.bussinesslogicservice.storeblservice.StoreBLService;
import main.po.StorePlacePO;
import main.po.VerificationPO;
import main.vo.IORecordVO;

public class StoreBLService_Stub implements StoreBLService {

	@Override
	public void newInStore() {
		// TODO Auto-generated method stub
		System.out.println("A new InStore Task Created!");
	}

	@Override
	public ResultMessage addInStoreGoods(long id, StorePlacePO place,
			String destination) {
		// TODO Auto-generated method stub
		if(id >= 1000000000 && id <= Long.MAX_VALUE){
			if(place.ifEmpty()){
				return new ResultMessage("success", null);
			}
			else{
				return new ResultMessage("usedplace", null);
			}
		}
		else{
			return new ResultMessage("wronggoods", null);
		}
	}

	@Override
	public ResultMessage delInStoreGoods(long id) {
		// TODO Auto-generated method stub
		if(id == 1111111111){
			return new ResultMessage("success", null);
		}
		else{
			return new ResultMessage("noexist", null);
		}
		
	}

	@Override
	public void endIntStore(int condition) {
		// TODO Auto-generated method stub

		System.out.println("The InStore task ended!");
	}

	@Override
	public void newOutStore() {
		// TODO Auto-generated method stub
		System.out.println("A new OutStore Task Created!");

	}

	@Override
	public ResultMessage addOutStoreGoods(long id, Trans trans,
			String Destination) {
		// TODO Auto-generated method stub
		if(id == 1111111111){
			return new ResultMessage("success", null);
		}
		else{
			return new ResultMessage("noexist", null);
		}
		
	}

	@Override
	public ResultMessage delOutStoreGoods(long id) {
		// TODO Auto-generated method stub
		if(id == 1111111111){
			return new ResultMessage("success", null);
		}
		else{
			return new ResultMessage("noexist", null);
		}
		
	}

	@Override
	public void endOutStore(int condition) {
		// TODO Auto-generated method stub

		System.out.println("The OutStore task ended!");
	}

	@Override
	public ResultMessage verification() {
		// TODO Auto-generated method stub
		System.out.println("A new verification task is created!");
		
		return new ResultMessage("success", new VerificationPO());
	}

	@Override
	public void endVerification(int condition) {
		// TODO Auto-generated method stub
		System.out.println("The verification task is ended!");
	}

	@Override
	public void newCheck() {
		// TODO Auto-generated method stub
		System.out.println("A new check task is created!");
	}

	@Override
	public ResultMessage check(Time start, Time end) {
		// TODO Auto-generated method stub
		ArrayList<IORecordVO> ior = new ArrayList();
		
		if(start.compareTo(end)<0){
			return new ResultMessage("success", ior);
		}
		else{
			return new ResultMessage("wrongtime", null);
		}
	}

	@Override
	public void newAdjust() {
		// TODO Auto-generated method stub
		System.out.println("A new adjust task is created!");
	}

	@Override
	public ResultMessage addAdjust(StorePlacePO start, StorePlacePO end) {
		// TODO Auto-generated method stub
		if(end.getArea()==1&&end.getRow()==1&&end.getShelf()==1&&end.getPlace()==1){
			return new ResultMessage("success!", null);
		}
		else{
			return new ResultMessage("endisfull", null);
		}
	}

	@Override
	public void endAdjust(int condition) {
		// TODO Auto-generated method stub
		System.out.println("The adjust task is ended!");
	}

}
