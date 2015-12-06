package main.vo;

import main.vo.storevo.StoreVO;


/**
 * 账本VO
 * Created by Away
 * 2015/11/16
 */

public class AccountVO {
    // 机构
    public InstitutionMessageVO institutionVO;

    // 人员
    public StaffMessageVO staffMessageVO;

    // 车辆
    public TruckMessageVO truckMessageVO;

    // 库存
    public StoreVO storeVO;

    // 银行账户
    public BankAccountVO bankAccountVO;

    public AccountVO(InstitutionMessageVO institutionVO, StaffMessageVO staffMessageVO, TruckMessageVO truckMessageVO, StoreVO storeVO, BankAccountVO bankAccountVO) {
        this.institutionVO = institutionVO;
        this.staffMessageVO = staffMessageVO;
        this.truckMessageVO = truckMessageVO;
        this.storeVO = storeVO;
        this.bankAccountVO = bankAccountVO;
    }
}
