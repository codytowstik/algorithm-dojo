package main.easy.maximum_subarray_53;

public class MaximumSubarray2 extends MaximumSubarray
{
	/**
	 * Kadane's Algorithm
	 *
	 * Runtime: O(n), 0ms, 100%
	 * Space: O(1), 39.2mb, 9.39%
	 *
	 * Like version 1, but set best_sum and current_sum to the first number in the array
	 *
	 * @param input the array
	 * @return the sum of the maximum subarray
	 */
	public int maxSubArray(int[] input)
	{
		int current_sum = input[0];
		int best_sum = input[0];

		for (int i = 1; i < input.length; i++)
		{
			int 	currentNumber = input[i];

			// reset current sum to current number if this sequence of numbers is negative (therefore won't add to any sequence)
			current_sum = Math.max(currentNumber, current_sum + currentNumber);

			best_sum = Math.max(best_sum, current_sum);
		}


		return best_sum;
	}
}
