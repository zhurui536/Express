package test.tester.storetester;

import static org.junit.Assert.*;

import org.junit.Test;

import main.bussinesslogic.storebl.StoreBLController;
import main.bussinesslogic.util.ResultMessage;
import test.mockObject.mockstoreobject.MockStorePlacePO;

public class InStoreTester {
	@Test
	public void test(){
		
		StoreBLController sc = new StoreBLController();
		ResultMessage result;
		
		result = sc.addInStoreGoods("001", new MockStorePlacePO(1, 1, 1, 1), "nanjing");
		assertEquals("success", result.getKey());
		
		result = sc.addInStoreGoods("002", new MockStorePlacePO(0, 1, 2, 4), "beijing");
		assertEquals("success", result.getKey());
		
		result = sc.delInStoreGoods("10010");
		assertEquals("noexist", result.getKey());
		
		result = sc.delInStoreGoods("002");
		assertEquals("success", result.getKey());
	}
}
