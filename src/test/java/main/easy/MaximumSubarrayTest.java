package main.easy;

import main.TestBase;
import main.easy.maximum_subarray_53.MaximumSubarray0;
import main.easy.maximum_subarray_53.MaximumSubarray1;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MaximumSubarrayTest extends TestBase
{
	@Disabled
	@Test
	public void testMaximumSubarray0()
	{
		testSolution(MaximumSubarray0.class);
	}

	@Test
	public void testMaximumSubarray1()
	{
		testSolution(MaximumSubarray1.class);
	}
}
