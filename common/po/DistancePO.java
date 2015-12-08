package po;

import java.io.Serializable;

import main.bussinesslogic.util.City;

public class DistancePO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 778486487108375645L;
	private City a;
	private City b;
	private double distance;
	
	public DistancePO(City a, City b, double distance){
		this.a = a;
		this.b = b;
		this.distance = distance;
	}
	
	public boolean ifMatch(City a, City b){
		if(this.a == a&&this.b == b)
			return true;
		if(this.b == a&&this.a == b)
			return true;
		
		return false;
	}
	
	public double getDistance(){
		return this.distance;
	}
}
