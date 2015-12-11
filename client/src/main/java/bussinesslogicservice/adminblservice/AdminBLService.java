package bussinesslogicservice.adminblservice;

import util.ResultMessage;
import vo.UserVO;

public interface AdminBLService {
	public ResultMessage addUser(UserVO user);
	
	public ResultMessage delUser(UserVO user);
	
	public ResultMessage modifyUser(UserVO user);
	
	public ResultMessage getUser();
	
	public ResultMessage end(int condition);
}
