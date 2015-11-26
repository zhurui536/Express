package test.tester.storetester;

import static org.junit.Assert.*;
import main.bussinesslogic.storebl.StoreBLController;
import main.bussinesslogic.util.ResultMessage;

import org.junit.Test;

public class VerificationTester {
	@Test
	public void test(){
		
		StoreBLController sc = new StoreBLController(null);
		ResultMessage result;
		
		result = sc.verification();
		assertEquals("success", result.getKey());
	}
}
