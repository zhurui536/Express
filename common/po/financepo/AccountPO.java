package po.financepo;

import main.vo.*;
import main.vo.storevo.VerificationVO;
import po.InstitutionMessagePO;
import po.StaffMessagePO;
import po.TruckMessagePO;
import po.storepo.StorePO;

import java.io.Serializable;

/**
 * 账本PO
 * Created by Away
 * 2015/10/26
 */

public class AccountPO implements Serializable {

    private static final long serialVersionUID = 6264983247235154666L;

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

    public AccountPO(AccountVO accountVO) {
        InstitutionMessageVO institutionMessageVO = accountVO.institutionVO;
        StaffMessageVO staffMessageVO = accountVO.staffMessageVO;
        TruckMessageVO truckMessageVO = accountVO.truckMessageVO;
        VerificationVO storeVO = accountVO.storeVO;
        BankAccountVO bankAccountVO = accountVO.bankAccountVO;
        InstitutionMessagePO institutionMessagePO = new InstitutionMessagePO(institutionMessageVO);
        StaffMessagePO staffMessagePO = new StaffMessagePO(staffMessageVO);
        TruckMessagePO truckMessagePO = new TruckMessagePO(truckMessageVO);
        StorePO storePO = new StorePO(storeVO);
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
