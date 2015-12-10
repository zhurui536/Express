package vo;


import util.City;

public class DistanceVO {
	private City a;
	private City b;
	private double distance;
	
	public DistanceVO(City a, City b, double distance){
		this.a = a;
		this.b = b;
		this.distance = distance;
	}
	
	public City getCityA(){
		return this.a;
	}
	
	public City getCityB(){
		return this.b;
	}
	
	public double getDistance(){
		return this.distance;
	}
}
