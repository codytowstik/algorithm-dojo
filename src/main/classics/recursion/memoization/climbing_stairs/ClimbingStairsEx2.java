package main.classics.recursion.memoization.climbing_stairs;

/**
 * Example: Dynamic programming.
 *
 * Runtime: O(n) - single loop, up to n
 * Space: O(n) - dp array of size n is used
 */
public class ClimbingStairsEx2 extends ClimbingStairs
{
	@Override
	public int climbStairs(int n)
	{
		if (n == 1)
		{
			return 1;
		}

		int[] 	dp = new int[n + 1];

		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++)
		{
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}
}
