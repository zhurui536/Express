package test.tester.storetester;

import static org.junit.Assert.*;
import main.bussinesslogic.storebl.StoreBLController;
import main.bussinesslogic.util.ResultMessage;

import org.junit.Test;

import test.mockObject.mockstoreobject.MockStorePlacePO;

public class AdjustTester {
	@Test
	public void test(){
		
		StoreBLController sc = new StoreBLController();
		ResultMessage result;
		
		result = sc.addAdjust(new MockStorePlacePO(1, 1, 1, 1), new MockStorePlacePO(1, 0, 2, 3));
		assertEquals("success", result.getKey());
	}
}
