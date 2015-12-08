package po.financepo;

import main.bussinesslogic.util.Time;
import main.vo.*;
import main.vo.storevo.StoreVO;
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

    // 建账时间
    private Time time;

    // 机构
    private InstitutionMessagePO institutionPO;

    // 人员
    private StaffMessagePO staffPO;

    // 车辆
    private TruckMessagePO truckPO;

    // 库存
    private StorePO storePO;

    // 银行账户
    private BankAccountPO bankAccountPO;

    public AccountPO(InstitutionMessagePO institutionPO, StaffMessagePO staffPO,
                     TruckMessagePO truckPO, StorePO storePO, BankAccountPO bankAccountPO, Time time) {
        this.institutionPO = institutionPO;
        this.staffPO = staffPO;
        this.truckPO = truckPO;
        this.storePO = storePO;
        this.bankAccountPO = bankAccountPO;
        this.time = time;
    }

    public AccountPO(AccountVO accountVO) {
        InstitutionMessageVO institutionMessageVO = accountVO.institutionVO;
        StaffMessageVO staffMessageVO = accountVO.staffMessageVO;
        TruckMessageVO truckMessageVO = accountVO.truckMessageVO;
        StoreVO storeVO = accountVO.storeVO;
        BankAccountVO bankAccountVO = accountVO.bankAccountVO;

        this.institutionPO = new InstitutionMessagePO(institutionMessageVO);
        this.staffPO = new StaffMessagePO(staffMessageVO);
        this.truckPO = new TruckMessagePO(truckMessageVO);
        this.storePO = new StorePO(storeVO);
        this.bankAccountPO = new BankAccountPO(bankAccountVO);
        this.time = accountVO.time;
    }

    public AccountVO poToVo() {
        InstitutionMessageVO institutionMessageVO = this.institutionPO.poToVo();
        StaffMessageVO staffMessageVO = this.staffPO.poToVo();
        TruckMessageVO truckMessageVO = this.truckPO.poToVo();
        StoreVO storeVO = this.storePO.poToVo();
        BankAccountVO bankAccountVO = this.bankAccountPO.poToVo();
        return new AccountVO(institutionMessageVO, staffMessageVO, truckMessageVO,
                storeVO, bankAccountVO, this.time);
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
