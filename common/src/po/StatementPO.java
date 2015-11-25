package po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 经营情况表
 * Created by Away
 * 2015/10/26
 */

public class StatementPO implements Serializable {


    // TODO 详细单据类型
    // 收款单
    private ArrayList<BillPO> receipt;

    // 付款单
    private ArrayList<BillPO> payList;

    public StatementPO(ArrayList<BillPO> receipt, ArrayList<BillPO> payList) {
        this.receipt = receipt;
        this.payList = payList;
    }

    public ArrayList<BillPO> getReceipt() {
        return receipt;
    }

    public void setReceipt(ArrayList<BillPO> receipt) {
        this.receipt = receipt;
    }

    public ArrayList<BillPO> getPayList() {
        return payList;
    }

    public void setPayList(ArrayList<BillPO> payList) {
        this.payList = payList;
    }
}
