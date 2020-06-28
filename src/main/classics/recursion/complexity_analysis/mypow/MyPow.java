package main.classics.recursion.complexity_analysis.mypow;

import main.utils.Solution;
import main.utils.SolutionInput;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2380/
 *
 * Implement pow(x, n), which calculates x raised to the power n -- (x^n).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public abstract class MyPow implements Solution
{
	@Override
	public Object execute(SolutionInput input)
	{
		double 	x = (double) input.getFirstInput();

		int		n = (int) input.getInputAtIndex(1);

		return myPow(x, n);
	}

	public abstract double myPow(double x, int n);
}
