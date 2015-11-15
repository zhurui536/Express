package main.po;

import java.io.Serializable;

import main.po.storepo.StorePO;

/**
 * 账本PO
 * Created by Away
 * 2015/10/26
 */

public class AccountPO implements Serializable {

    // 机构
    InstitutionMessagePO institutionPO;

    // 人员
    StaffMessagePO staffPO;

    // 车辆
    TruckMessagePO truckPO;

    // 库存
    StorePO storePO;

    // 银行账户
    BankAccountPO bankAccountPO;

    public AccountPO(InstitutionMessagePO institutionPO, StaffMessagePO staffPO,
                     TruckMessagePO truckPO, StorePO storePO, BankAccountPO bankAccountPO) {
        this.institutionPO = institutionPO;
        this.staffPO = staffPO;
        this.truckPO = truckPO;
        this.storePO = storePO;
        this.bankAccountPO = bankAccountPO;
    }

    public InstitutionMessagePO getInstitutionPO() {
        return institutionPO;
    }

    public StaffMessagePO getStaffPO() {
        return staffPO;
    }

    public TruckMessagePO getTruckPO() {
        return truckPO;
    }

    public StorePO getStorePO() {
        return storePO;
    }

    public BankAccountPO getBankAccountPO() {
        return bankAccountPO;
    }

    public void setInstitutionPO(InstitutionMessagePO institutionPO) {
        this.institutionPO = institutionPO;
    }

    public void setStaffPO(StaffMessagePO staffPO) {
        this.staffPO = staffPO;
    }

    public void setTruckPO(TruckMessagePO truckPO) {
        this.truckPO = truckPO;
    }

    public void setStorePO(StorePO storePO) {
        this.storePO = storePO;
    }

    public void setBankAccountPO(BankAccountPO bankAccountPO) {
        this.bankAccountPO = bankAccountPO;
    }
}
