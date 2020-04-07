package main.medium.threesum_15;

import main.utils.SolutionEx;

import java.util.List;

public abstract class ThreeSum implements SolutionEx
{
	public Object execute(Object input)
	{
		return threeSum((int[]) input);
	}

	abstract public List<List<Integer>> threeSum(int[] nums);
}
