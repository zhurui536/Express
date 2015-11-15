package test.tester.storetester;

import static org.junit.Assert.*;
import main.bussinesslogic.storebl.StoreBLController;
import main.bussinesslogic.util.ResultMessage;

import org.junit.Test;

public class VerifcationTester {
	@Test
	public void test(){
		
		StoreBLController sc = new StoreBLController();
		ResultMessage result;
		
		result = sc.verification();
		assertEquals("success", result.getKey());
	}
}
