package main.classics.recursion.memoization.climbing_stairs;

public class ClimbingStairs0 extends ClimbingStairs
{
	// it takes n steps to reach the top
	// each time you can either climb 1 or 2 steps
	// how many distinct ways can you reach the top?

	@Override
	public int climbStairs(int n)
	{
		if (n == 0 || n == 1 || n == 2)
		{
			return n;
		}

		int 	total = climbStairs(n - 1);

		total += climbStairs(n - 2);

		return total;
	}
}
