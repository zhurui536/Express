package test.tester.financetester;

import main.bussinesslogic.financebl.FinanceController;
import main.vo.*;
import main.vo.storevo.StoreVO;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * 期初建账测试
 * Created by Away
 * 2015/11/16
 */

public class InitTester {
    @Test
    public void test(){
        InstitutionMessageVO institution = new InstitutionMessageVO(null,null,null);
        StaffMessageVO staff = new StaffMessageVO(null, null);
        TruckMessageVO truck = new TruckMessageVO(null,null,0);
        StoreVO store = new StoreVO(null);
        BankAccountVO bankAccount = new BankAccountVO("kkk", BigDecimal.valueOf(123465), "465456555");
        AccountVO accountVO = new AccountVO(institution, staff, truck, store, bankAccount);
        FinanceController controller = new FinanceController();
        assertEquals("success", controller.createAccounting(accountVO).getKey());
    }
}
