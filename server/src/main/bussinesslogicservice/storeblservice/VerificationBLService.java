package main.bussinesslogicservice.storeblservice;

import main.bussinesslogic.util.ResultMessage;

public interface VerificationBLService {
	
	public ResultMessage verification();
	
	public void endVerification(int condition);
}
