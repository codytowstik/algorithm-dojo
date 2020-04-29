package main.classics.recursion.memoization.climbing_stairs;

/**
 * Example: Recursion with memoization.
 *
 * Runtime: O(n) - recursion tree can be of size n
 * Space: O(n) - depth of recursion tree can go up to n
 */
public class ClimbingStairsEx1 extends ClimbingStairs
{
	@Override
	public int climbStairs(int n)
	{
		int 	memo[] = new int[n + 1];

		return climb_Stairs(0, n, memo);
	}

	public int climb_Stairs(int i, int n, int memo[])
	{
		if (i > n)
		{
			return 0;
		}

		if (i == n)
		{
			return 1;
		}

		if (memo[i] > 0)
		{
			return memo[i];
		}

		memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);

		return memo[i];
	}
}
