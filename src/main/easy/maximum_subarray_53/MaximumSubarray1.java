package main.easy.maximum_subarray_53;

public class MaximumSubarray1 extends MaximumSubarray
{
	/**
	 * SingleNumber.
	 *
	 * Fori implementation.
	 *
	 * 1ms, 51%
	 *
	 * @param input
	 * @return
	 */
	public int maxSubArray(int[] input)
	{
		int singleNumber = input[0];

		for (int i = 1; i < input.length; i++)
		{
			singleNumber ^= input[i];
		}

		return singleNumber;
	}
}
