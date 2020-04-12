package main.easy.maximum_subarray_53;

import main.utils.Solution;
import main.utils.SolutionInput;

public abstract class MaximumSubarray implements Solution
{
	public Object execute(SolutionInput solutionInput)
	{
		int[] 	nums = (int[]) solutionInput.getFirstInput();

		return maxSubArray(nums);
	}

	abstract int maxSubArray(int[] nums);
}
