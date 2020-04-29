package main.classics.recursion.memoization.climbing_stairs;

/**
 * Example: Fibonacci Number.
 *
 * Runtime: O(n) - single loop up to n is required to calculate nth fibonacci number
 * Space: O(1)
 */
public class ClimbingStairsEx3 extends ClimbingStairs
{
	@Override
	public int climbStairs(int n)
	{
		if (n == 1)
		{
			return 1;
		}

		int 	first = 1;
		int 	second = 2;

		for (int i = 3; i <= n; i++)
		{
			int 	third = first + second;

			first = second;
			second = third;
		}

		return second;
	}
}
