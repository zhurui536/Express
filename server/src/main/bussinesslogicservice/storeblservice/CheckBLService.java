package main.bussinesslogicservice.storeblservice;

import java.sql.Time;

import main.bussinesslogic.util.ResultMessage;

public interface CheckBLService {
	public void newCheck();
	
	public ResultMessage check(Time start, Time end);
}
