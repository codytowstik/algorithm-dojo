package main.classics.recursion.memoization.climbing_stairs;

/**
 * Example: Fibonacci calculated.
 *
 * Runtime: O(logn) - pow method takes log n time
 * Space: O(1)
 */
public class ClimbingStairsEx4 extends ClimbingStairs
{
	@Override
	public int climbStairs(int n)
	{
		double 	sqrt5 = Math.sqrt(5);

		double 	fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);

		return (int) (fibn / sqrt5);
	}
}
