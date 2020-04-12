package main.easy.maximum_subarray_53;

public class MaximumSubarray0 extends MaximumSubarray
{
	/**
	 * Brute force.
	 *
	 * Runtime: O(n^2)
	 *
	 * for each number, we need to check every other number
	 *
	 * Space: O(1)
	 * 	we only store max number, and indices of the subarray that makes that number
	 *
	 *
	 * set maximum found number to negative infinity
	 * set maxSubarray indices to lo=0, hi=1
	 * for each number,
	 * 		set lo index to current number index, hi index to remaining numbers
	 * 		for each remaining value,
	 * 			if sum of values from lo index to hi index is greater than max, save that as max and the indices of that subarray
	 *
	 * return the sum of the numbers from [lo,hi)
	 */
	public int maxSubArray(int[] input)
	{
		return 0;
	}
}
