package main.classics.recursion.memoization.fibonacci;

/**
 * Fibonacci.
 *
 * Runtime: O(2^n) - each level of recursion grows exponentially as depth approaches N
 *
 * Space: O(N) = space proportionate to N to account for the max size of the stack in memory.
 *
 * Classic recursion, no memoization.
 */
public class Fibonacci0 extends Fibonacci
{
	@Override
	public int fib(int n)
	{
		if (n == 0)
		{
			return 0;
		}
		else if (n == 1)
		{
			return 1;
		}

		// F(n) = F(N-1) + F(N-2) for N > 1

		return fib(n - 1) + fib(n - 2);
	}
}
