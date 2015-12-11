package po;


import util.Job;
import util.SalaryType;
import vo.StaffMessageVO;

import java.io.Serializable;

/**
 * 人员PO
 * Created by Away
 * 2015/10/26
 */

public class StaffMessagePO implements Serializable {

    private static final long serialVersionUID = 3927616662282852133L;

    // 员工编号
    String id;

    // 员工名称
    String name;
    
    //员工职位
    Job job;
    
    //员工薪水
    SalaryPO salary;
    
    //所属机构
    String institutionid;

    public StaffMessagePO(String id, String name, String institutionid, Job job, SalaryType type, double salary) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.salary = new SalaryPO(salary, type);
        this.institutionid = institutionid;
    }



    public StaffMessagePO(StaffMessageVO vo) {
        this.id = vo.id;
        this.name = vo.name;
        this.job = vo.job;
        this.salary = new SalaryPO(vo.salary.getSalary(), vo.salary.getType());
        this.institutionid = vo.institutionid;
    }


    public StaffMessageVO poToVo() {
        return new StaffMessageVO(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setSalary(SalaryPO salary){
    	this.salary = salary;
    }
    
    public SalaryPO getSalary(){
    	return this.salary;
    }
    
    public String getInstitutionid(){
    	return this.institutionid;
    }
    
    public void setInstitutionid(String id){
    	this.institutionid = id;
    }
    
    public void setJob(Job job){
    	this.job = job;
    }
    
    public Job getJob(){
    	return this.job;
    }
}
