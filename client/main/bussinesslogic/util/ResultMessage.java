package main.bussinesslogic.util;

import java.io.Serializable;

/**
 * Created by Away
 * 2015/10/26
 */

@SuppressWarnings("serial")
public class ResultMessage implements Serializable {
	private String key;
	private Object value;
	
	public ResultMessage(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	public ResultMessage(String key) {
		this.key = key;
		this.value = null;
	}

	public String getKey(){
		return key;
	}
	
	public Object getValue(){
		return value;
	}
}
