package main.easy.two_sum_1;

import main.utils.Solution;
import main.utils.SolutionInput;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
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
