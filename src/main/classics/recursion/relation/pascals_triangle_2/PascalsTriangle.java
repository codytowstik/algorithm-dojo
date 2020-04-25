package main.classics.recursion.relation.pascals_triangle_2;

import main.utils.Solution;
import main.utils.SolutionInput;

import java.util.List;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public abstract class PascalsTriangle implements Solution
{
	@Override
	public Object execute(SolutionInput input)
	{
		int		rowIndex = (int) input.getFirstInput();

		return getRow(rowIndex);
	}

	public abstract List<Integer> getRow(int rowIndex);
}
