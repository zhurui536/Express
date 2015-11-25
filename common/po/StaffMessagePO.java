package po;

/**
 * 人员PO
 * Created by Away
 * 2015/10/26
 */

public class StaffMessagePO {

    // 员工编号
    String id;

    // 员工名称
    String name;

    public StaffMessagePO(String id, String name) {
        this.id = id;
        this.name = name;
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
}
