package main.classics.recursion.memoization.climbing_stairs;

/**
 * Example: Brute force.
 *
 * Runtime: O(2^n)
 * Space: O(n) - depth of recursion tree can go up to n
 *
 * Idiomatic recursive impl.
 */
public class ClimbingStairsEx0 extends ClimbingStairs
{
	@Override
	public int climbStairs(int n)
	{
		return climb_Stairs(0, n);
	}

	public int climb_Stairs(int i, int n)
	{
		if (i > n)
		{
			return 0;
		}

		if (i == n)
		{
			return 1;
		}

		return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
	}
}
