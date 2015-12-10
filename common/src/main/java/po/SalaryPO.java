package po;

import util.Job;
import util.SalaryType;

import java.io.Serializable;

public class SalaryPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5998318940899770901L;
	private String id;
	private Job job;
	private double salary;
	private SalaryType type;
	public SalaryPO(String id, Job job, double salary, SalaryType type){
		this.setId(id);
		this.setSalary(salary);
		this.setJob(job);
		this.setType(type);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	
}
