package main.medium.threesum_15;

import main.utils.Solution;
import main.utils.SolutionInput;

import java.util.List;

public abstract class ThreeSum implements Solution
{
	public Object execute(SolutionInput input)
	{
		int[]	nums = (int[]) input.getFirstInput();

		return threeSum(nums);
	}

	abstract public List<List<Integer>> threeSum(int[] nums);
}
