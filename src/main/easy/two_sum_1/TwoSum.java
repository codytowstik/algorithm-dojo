package main.easy.two_sum_1;

import main.utils.Solution;
import main.utils.SolutionInput;

public abstract class TwoSum implements Solution
{
	public Object execute(SolutionInput input)
	{
		int[] 	nums = (int[]) input.getInputAtIndex(0);
		int 	target = (int) input.getInputAtIndex(1);

		return twoSum(nums, target);
	}

	abstract int[] twoSum(int[] nums, int target);
}
