package main.vo;

import main.bussinesslogic.util.Job;
import main.bussinesslogic.util.SalaryType;

public class SalaryVO {
	private String id;
	private Job job;
	private double salary;
	private SalaryType type;
	public SalaryVO(String id, Job job, double salary, SalaryType type){
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
