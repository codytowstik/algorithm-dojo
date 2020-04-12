package main.easy.maximum_subarray_53;

import java.util.Arrays;

public class MaximumSubarray2 extends MaximumSubarray
{
	/**
	 * SingleNumber.
	 *
	 * Stream implementation.
	 *
	 * 4ms, 39.6%
	 * 43.3mb, 5.19%
	 *
	 * @param input
	 * @return
	 */
	public int maxSubArray(int[] input)
	{
		int singleNumber =
			Arrays
				.stream(input)
				.reduce(0, (collector, value) -> collector ^= value);

		return singleNumber;
	}
}
