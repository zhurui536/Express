package test.tester.storetester;

import static org.junit.Assert.assertEquals;
import main.bussinesslogic.storebl.StoreBLController;
import main.bussinesslogic.util.ResultMessage;
import main.bussinesslogic.util.Trans;

import org.junit.Test;

public class OutStoreTester {
	@Test
	public void test(){
		
		StoreBLController sc = new StoreBLController();
		ResultMessage result;
		
		result = sc.addOutStoreGoods("001", Trans.PLANE, "nanjing");
		assertEquals("success", result.getKey());
		
		result = sc.addOutStoreGoods("002", Trans.TRUCK, "beijing");
		assertEquals("success", result.getKey());
		
		result = sc.delOutStoreGoods("10010");
		assertEquals("noexist", result.getKey());
		
		result = sc.delOutStoreGoods("002");
		assertEquals("success", result.getKey());
	}
}
