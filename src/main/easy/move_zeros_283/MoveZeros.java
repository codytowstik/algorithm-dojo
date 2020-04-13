package main.easy.move_zeros_283;

import main.utils.Solution;
import main.utils.SolutionInput;

/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public abstract class MoveZeros implements Solution
{
	public Object execute(SolutionInput solutionInput)
	{
		int[] 		nums = (int[]) solutionInput.getFirstInput();

		return moveZeroesWrapper(nums);
	}

	public int[] moveZeroesWrapper(int[] nums)
	{
		moveZeroes(nums);

		return nums;
	}

	public void moveZeroes(int[] nums)
	{

	}
}
