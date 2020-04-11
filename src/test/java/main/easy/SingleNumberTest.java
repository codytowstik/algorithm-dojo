package main.easy;

import main.TestBase;
import main.easy.single_number_136.SingleNumber0;
import main.easy.single_number_136.SingleNumber1;
import main.easy.single_number_136.SingleNumber2;
import org.junit.jupiter.api.Test;

/**
 * int singleNumber(int[] input)
 */
public final class SingleNumberTest extends TestBase
{
	@Test
	public void testSingleNumber0()
	{
		testSolution(SingleNumber0.class);
	}

	@Test
	public void testSingleNumber1()
	{
		testSolution(SingleNumber1.class);
	}

	@Test
	public void testSingleNumber2()
	{
		testSolution(SingleNumber2.class);
	}
}
