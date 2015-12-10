package bussinesslogicservice.storeblservice;


import util.ResultMessage;

public interface VerificationBLService {
	
	/*新建盘点任务并生成盘点结果
	 * 无
	 * ResultMessage
	 */
	public ResultMessage verification();
	
	/*结束库存盘点
	 * conditon
	 * 无
	 */
	public ResultMessage endVerification(int condition);
}
