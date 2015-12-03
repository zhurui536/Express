package po;

import java.io.Serializable;

/**
 * 机构信息PO
 * Created by Away
 * 2015/10/26
 */

public class InstitutionMessagePO implements Serializable {

    private static final long serialVersionUID = 1374906017869308736L;

    // 机构名称
    String name;

    // 机构编号
    String id;

    public InstitutionMessagePO(String name, String id) {
        this.name = name;
        this.id = id;
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
