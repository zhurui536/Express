package main.bussinesslogicservice.storeblservice._stub;

import java.util.ArrayList;
import java.util.Calendar;

import test.mockObject.mockstoreobject.MockStorePlacePO;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Trans;
import main.bussinesslogicservice.storeblservice.StoreBLService;
import po.storepo.StorePO;
import po.storepo.StorePlacePO;
import po.storepo.VerificationPO;
import main.vo.IORecordVO;
/**
 * Created By ZHR
 * 2015/10/26
 */
public class StoreBLService_Stub implements StoreBLService {

	@Override
	public void newInStore() {
		// TODO Auto-generated method stub
		System.out.println("A new InStore Task Created!");
	}

	@Override
	public ResultMessage addInStoreGoods(String id, StorePlacePO place,
			String destination) {
		// TODO Auto-generated method stub
		if(id.equals("111111111") || id.equals("100000000")){
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
	public ResultMessage delInStoreGoods(String id) {
		// TODO Auto-generated method stub
		if(id.equals("111111111")){
			return new ResultMessage("success", null);
		}
		else{
			return new ResultMessage("noexist", null);
		}
		
	}

	@Override
	public void endIntStore(int condition) {
		// TODO Auto-generated method stub
		if(condition == 0){
			System.out.println("The InStore task ended!");
		}
		if(condition == 1){
			System.out.println("The InStore task is cancled!");
		}
	}

	@Override
	public void newOutStore() {
		// TODO Auto-generated method stub
		System.out.println("A new OutStore Task Created!");

	}

	@Override
	public ResultMessage addOutStoreGoods(String id, Trans trans,
			String Destination) {
		// TODO Auto-generated method stub
		if(id.equals("111111111")){
			return new ResultMessage("success", null);
		}
		else{
			return new ResultMessage("noexist", null);
		}
		
	}

	@Override
	public ResultMessage delOutStoreGoods(String id) {
		// TODO Auto-generated method stub
		if(id.equals("111111111")){
			return new ResultMessage("success", null);
		}
		else{
			return new ResultMessage("noexist", null);
		}

	}

	@Override
	public void endOutStore(int condition) {
		// TODO Auto-generated method stub
		if(condition == 0){
			System.out.println("The OutStore task ended!");
		}
		if(condition == 1){
			System.out.println("The OutStore task is cancled!");
		}
	}

	@Override
	public ResultMessage verification() {
		// TODO Auto-generated method stub
		System.out.println("A new verification task is created!");
		
		return new ResultMessage("success", new VerificationPO(new StorePO(2, 3, 4, 5)));
	}

	@Override
	public void endVerification(int condition) {
		// TODO Auto-generated method stub
		if(condition == 0){
			System.out.println("The verification task is ended!");
		}
		if(condition == 1){
			System.out.println("The verification task is cancled!");
		}
	}

	@Override
	public void newCheck() {
		// TODO Auto-generated method stub
		System.out.println("A new check task is created!");
	}

	@Override
	public ResultMessage check(Calendar start, Calendar end) {
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
		if(condition == 0){
			System.out.println("The adjust task is ended!");
		}
		if(condition == 1){
			System.out.println("The adjust task is cancled!");
		}
	}

	@Override
	public ResultMessage delAdjust(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
