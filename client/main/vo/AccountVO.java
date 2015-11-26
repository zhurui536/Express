package main.vo;


/**
 * 账本VO
 * Created by Away
 * 2015/11/16
 */

public class AccountVO {
    // 机构
    InstitutionMessageVO institutionVO;

    // 人员
    StaffMessageVO staffMessageVO;

    // 车辆
    TruckMessageVO truckMessageVO;

    // 库存
    StoreVO storeVO;

    // 银行账户
    BankAccountVO bankAccountVO;

    public AccountVO(InstitutionMessageVO institutionVO, StaffMessageVO staffMessageVO, TruckMessageVO truckMessageVO, StoreVO storeVO, BankAccountVO bankAccountVO) {
        this.institutionVO = institutionVO;
        this.staffMessageVO = staffMessageVO;
        this.truckMessageVO = truckMessageVO;
        this.storeVO = storeVO;
        this.bankAccountVO = bankAccountVO;
    }

    public InstitutionMessageVO getInstitutionVO() {
        return institutionVO;
    }

    public void setInstitutionVO(InstitutionMessageVO institutionVO) {
        this.institutionVO = institutionVO;
    }

    public StaffMessageVO getStaffMessageVO() {
        return staffMessageVO;
    }

    public void setStaffMessageVO(StaffMessageVO staffMessageVO) {
        this.staffMessageVO = staffMessageVO;
    }

    public TruckMessageVO getTruckMessageVO() {
        return truckMessageVO;
    }

    public void setTruckMessageVO(TruckMessageVO truckMessageVO) {
        this.truckMessageVO = truckMessageVO;
    }

    public StoreVO getStoreVO() {
        return storeVO;
    }

    public void setStoreVO(StoreVO storeVO) {
        this.storeVO = storeVO;
    }

    public BankAccountVO getBankAccountVO() {
        return bankAccountVO;
    }

    public void setBankAccountVO(BankAccountVO bankAccountVO) {
        this.bankAccountVO = bankAccountVO;
    }
}
