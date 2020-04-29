package main.classics.recursion.memoization.climbing_stairs;

import main.utils.Solution;
import main.utils.SolutionInput;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1662/
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public abstract class ClimbingStairs implements Solution
{
	@Override
	public Object execute(SolutionInput input)
	{
		int n = (int) input.getFirstInput();

		return climbStairs(n);
	}

	public abstract int climbStairs(int n);
}
