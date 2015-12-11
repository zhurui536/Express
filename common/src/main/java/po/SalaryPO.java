package po;

import util.SalaryType;

import java.io.Serializable;

public class SalaryPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5998318940899770901L;
	private double salary;
	private SalaryType type;
	public SalaryPO(double salary, SalaryType type){
		this.setSalary(salary);
		this.setType(type);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public SalaryType getType() {
		return type;
	}

	public void setType(SalaryType type) {
		this.type = type;
	}
	
}
