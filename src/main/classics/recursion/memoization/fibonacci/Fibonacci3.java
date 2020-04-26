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
	private Integer[] cache = new Integer[31];

	@Override
	public int fib(int n)
	{
		if (n <= 1)
		{
			return n;
		}

		cache[0] = 0;
		cache[1] = 1;

		return memoize(n);
	}

	private int memoize(int n)
	{
		if (cache[n] != null)
		{
			return cache[n];
		}

		cache[n] = memoize(n -1) + memoize(n - 2);

		return memoize(n);
	}
}
