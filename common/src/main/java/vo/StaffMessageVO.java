package vo;

import po.StaffMessagePO;
import util.Job;

/**
 * @author zhuding
 *
 */
public class StaffMessageVO {

    public String id;

    public String name;
    
    public Job job;
    
    public SalaryVO salary;
    
    public String institutionid;

    public StaffMessageVO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public StaffMessageVO() {
    }
    
    public StaffMessageVO(StaffMessagePO po) {
    	this.id = po.getId();
    	this.name = po.getName();
    	this.job = po.getJob();
    	this.salary = new SalaryVO(po.getSalary().getSalary(), po.getSalary().getType());
    	this.institutionid = po.getInstitutionid();
    }  
}
