package main.medium.threesum_15;

import main.utils.Solution;
import main.utils.SolutionInput;

import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public abstract class ThreeSum implements Solution
{
	public Object execute(SolutionInput input)
	{
		int[]	nums = (int[]) input.getFirstInput();

		return threeSum(nums);
	}

	abstract public List<List<Integer>> threeSum(int[] nums);
}
