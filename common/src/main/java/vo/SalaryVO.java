package vo;


import util.SalaryType;

public class SalaryVO {
	private double salary;
	private SalaryType type;
	public SalaryVO(double salary, SalaryType type){
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
