package main.easy.two_sum_1;

import main.utils.SolutionEx;

public abstract class TwoSum implements SolutionEx
{
	public Object execute(Object input)
	{
		return twoSum((int[]) input, 1);
	}

	abstract int[] twoSum(int[] nums, int target);
}
