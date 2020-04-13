package main.easy.maximum_subarray_53;

public class MaximumSubarray1 extends MaximumSubarray
{
	/**
	 * Kadane's Algorithm
	 *
	 * Runtime: O(n), 1ms, 69.87%
	 * Space: O(1), 39.2mb, 9.39%
	 *
	 * track the 'current_sum' and the 'best_sum'
	 *
	 * current_sum tracks the sum from the last time the sum is greater than zero.. eliminating and subarray sequence
	 * that isn't positive and doesn't contribute to our local maxima
	 *
	 * best_sum tracks the highest sequence of numbers we have encountered yet
	 *
	 * @param input the array
	 * @return the sum of the maximum subarray
	 */
	public int maxSubArray(int[] input)
	{
		int current_sum = 0;
		int best_sum = Integer.MIN_VALUE;

		for (int i = 0; i < input.length; i++)
		{
			int 	currentNumber = input[i];

			// reset current sum to current number if this sequence of numbers is negative (therefore won't add to any sequence)
			current_sum = Math.max(currentNumber, current_sum + currentNumber);

			best_sum = Math.max(best_sum, current_sum);
		}


		return best_sum;
	}
}
