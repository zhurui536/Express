package main.vo;

public class CheckVO {
	private int numOfIn;
	private int numOfOut;
	private double valueOfIn;
	private double valueOfOut;
	private int numOfUsed;
	private int numOfEmpty;
	
	public CheckVO(int nu, int ne){
		this.numOfUsed = nu;
		this.numOfEmpty = ne;
	}
	
	public void setTotal(int ni, int no, double vi, double vo){
		this.numOfIn = ni;
		this.numOfOut = no;
		this.valueOfIn = vi;
		this.valueOfOut = vo;
	}
	
	public int getNumOfIn(){
		return this.numOfIn;
	}
	
	public int getNumOfOut(){
		return this.numOfOut;
	}
	
	public double getValueOfIn(){
		return this.valueOfIn;
	}
	
	public double getValueOfOut(){
		return this.valueOfOut;
	}
	
	public int getNumOfUsed(){
		return this.numOfUsed;
	}
	
	public int getNumOfEmpty(){
		return this.numOfEmpty;
	}

}
