package main.classics.recursion.memoization.fibonacci;

/**
 * Fibonacci.
 *
 * Runtime: O(N) - each number, starting at 2 and up to and including N, is visited, computed, and then stored for O(1) access later
 *
 * Space: O(N) - the size of the data structure is proportional to N
 *
 * Classic recursion, with memoization using decorator.
 */
public class Fibonacci4 extends Fibonacci
{
	@Override
	public int fib(int n)
	{
		if (n <= 1)
		{
			return n;
		}

		if (n == 2)
		{
			return 1;
		}

		int current = 0;
		int prev1 = 1;
		int prev2 = 1;

		for (int i = 3; i <= n; i++)
		{
			current = prev1 + prev2;
			prev2 = prev1;
			prev1 = current;
		}

		return current;
	}
}
