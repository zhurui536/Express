package po;

import java.io.Serializable;

import main.bussinesslogic.util.InstitutionType;
import main.vo.InstitutionMessageVO;

/**
 * 机构信息PO
 * Created by Away
 * 2015/10/26
 */

public class InstitutionMessagePO implements Serializable {

    private static final long serialVersionUID = 1374906017869308736L;

    // 机构名称
    private String name;

    // 机构编号
    private String id;

    //机构类型
    private InstitutionType institutionType;
    
    public InstitutionMessagePO(String name, String id,
                InstitutionType institutionType) {
        super();
        this.name = name;
        this.id = id;
        this.institutionType = institutionType;
}
    
    public InstitutionMessagePO(InstitutionMessageVO institutionMessageVO) {
        super();
        this.name = institutionMessageVO.name;
        this.id = institutionMessageVO.id;
        this.institutionType = institutionMessageVO.institutionType;
    }

    public InstitutionMessageVO poToVo(){
            return new InstitutionMessageVO(name, id, institutionType);
    }
    
public InstitutionType getInstitutionType() {
        return institutionType;
}

public void setInstitutionType(InstitutionType institutionType) {
        this.institutionType = institutionType;
}

public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
