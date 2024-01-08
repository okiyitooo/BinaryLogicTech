package Test;
import MyPackage.Sum;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumTest {

	@Test
	void calculateSum_arrayOf3Nums() {
		int arr[] = new int[3];
		Sum sum = new Sum();
		int actual = 0;
		assertEquals(actual, sum.calculateSum(arr));
	}

}
