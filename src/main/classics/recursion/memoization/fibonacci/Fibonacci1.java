package main.classics.recursion.memoization.fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * Fibonacci.
 *
 * Runtime: O(N) - each number, starting at 2 and up to and including N, is visited, computed, and then stored for O(1) access later
 *
 * Space: O(N) - the size of the data structure is proportional to N
 *
 * Classic recursion, with memoization using decorator.
 */
public class Fibonacci1 extends Fibonacci
{
	private Map<Integer,Integer> previouslyCalculatedNToResult;

	@Override
	public int fib(int n)
	{
		if (previouslyCalculatedNToResult == null)
		{
			previouslyCalculatedNToResult = new HashMap<>(n);
		}

		// n == 0 or n == 1
		if (n <= 1)
		{
			return n;
		}

		// F(n) = F(N-1) + F(N-2) for N > 1

		if (previouslyCalculatedNToResult.containsValue(n))
		{
			return previouslyCalculatedNToResult.get(n);
		}
		else
		{
			int 	result = fib(n - 1) + fib(n - 2);

			previouslyCalculatedNToResult.put(n, result);

			return result;
		}
	}
}
