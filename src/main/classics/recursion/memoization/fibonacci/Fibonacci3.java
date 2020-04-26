package main.classics.recursion.memoization.fibonacci;

/**
 * Fibonacci.
 *
 * Runtime: O(N) - each number, starting at 2 and up to and including N, is visited, computed, and then stored for O(1) access later
 *
 * Space: O(N) - the size of the data structure is proportional to N
 *
 * Classic recursion, Top-Down with memoization using decorator.
 */
public class Fibonacci3 extends Fibonacci
{
	@Override
	public int fib(int n)
	{
		if (n <= 1)
		{
			return n;
		}

		return memoize(n);
	}

	private int memoize(int n)
	{
		int[] 	cache = new int[n + 1];

		cache[1] = 1;

		// F(n) = F(N-1) + F(N-2) for N > 1

		for (int i = 2; i <= n; i++)
		{
			cache[i] = cache[i - 1] + cache[i - 2];
		}

		return cache[n];
	}
}
