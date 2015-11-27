package test.tester.financetester;

import main.bussinesslogic.financebl.FinanceController;
import main.vo.*;
import main.vo.storevo.StoreVO;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 期初建账测试
 * Created by Away
 * 2015/11/16
 */

public class InitTester {
    @Test
    public void test(){
        InstitutionMessageVO institution = new InstitutionMessageVO();
        StaffMessageVO staff = new StaffMessageVO();
        TruckMessageVO truck = new TruckMessageVO();
        StoreVO store = new StoreVO();
        BankAccountVO bankAccount = new BankAccountVO("kkk", 123465, "465456555");
        AccountVO accountVO = new AccountVO(institution, staff, truck, store, bankAccount);
        FinanceController controller = new FinanceController();
        assertEquals("success", controller.createAccounting(accountVO).getKey());
    }
}
