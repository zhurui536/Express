package bussinesslogic.storebl;

import java.util.Calendar;

import javax.swing.JTable;

import util.LogFactory;
import util.ResultMessage;
import util.Trans;
import vo.SystemlogVO;
import vo.storevo.StorePlaceVO;
import bussinesslogicservice.infoblservice.SystemlogMaintenanceBLService;
import bussinesslogicservice.storeblservice.StoreBLService;

public class StoreBLController implements StoreBLService {
	//以下为处理5种用例所用的逻辑处理对象
	private AdjustBL adjust;
	private CheckBL check;
	private InStoreBL instore;
	private OutStoreBL outstore;
	private VerificationBL verification;
	
	//编写系统日志
	private SystemlogMaintenanceBLService logservice;
	
	//表示当前的状态，0代表空闲
	private int condition;
	
	public StoreBLController(){
		this.condition = 0;
		logservice = LogFactory.getInstance();
	}

	@Override
	public ResultMessage newInStore() {
		if(condition == 0){
			instore = new InStoreBL();
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
			
			this.logservice.addSystemlog(new SystemlogVO("入库"));
		}
		return result;
	}

	@Override
	public ResultMessage newOutStore() {
		if(condition == 0){
			outstore = new OutStoreBL();
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
			this.logservice.addSystemlog(new SystemlogVO("出库"));
		}
		return result;
	}

	@Override
	public ResultMessage newAdjust() {
		if(condition == 0){
			adjust = new AdjustBL();
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
			this.logservice.addSystemlog(new SystemlogVO("库存调整"));
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
		this.logservice.addSystemlog(new SystemlogVO("库存查看"));
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
			verification = new VerificationBL();
			condition = 4;
			this.logservice.addSystemlog(new SystemlogVO("进行库存盘点"));
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
			this.logservice.addSystemlog(new SystemlogVO("保存库存盘点"));
		}
		return result;
	}

	@Override
	public ResultMessage exportVerification(JTable table) {
		this.logservice.addSystemlog(new SystemlogVO("导出库存快照"));
		return verification.exportVerification(table);
	}

}
