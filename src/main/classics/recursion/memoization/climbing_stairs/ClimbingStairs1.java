package main.classics.recursion.memoization.climbing_stairs;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs1 extends ClimbingStairs
{
	// it takes n steps to reach the top
	// each time you can either climb 1 or 2 steps
	// how many distinct ways can you reach the top?

	Map<Integer, Integer> previousResults = new HashMap<>();

	@Override
	public int climbStairs(int n)
	{
		if (n == 0 || n == 1 || n == 2)
		{
			return n;
		}

		int 	total;

		if (previousResults.containsValue(n - 1))
		{
			total = previousResults.get(n - 1);
		}
		else
		{
			int 	result = climbStairs(n - 1);

			total = result;

			previousResults.put(n - 1, result);
		}

		if (previousResults.containsValue(n - 2))
		{
			total += previousResults.get(n - 2);
		}
		else
		{
			int		result = climbStairs(n - 2);

			total += result;

			previousResults.put(n - 2, result);
		}

		return total;
	}
}
