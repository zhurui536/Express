package main.bussinesslogic.util;
/**
 * Created by Away
 * 2015/10/26
 */

public class ResultMessage {
	private String key;
	private Object value;
	
	public ResultMessage(String key, Object value){
		this.key = key;
		this.value = value;
	}
	
	public String getKey(){
		return key;
	}
	
	public Object getValue(){
		return value;
	}
}
