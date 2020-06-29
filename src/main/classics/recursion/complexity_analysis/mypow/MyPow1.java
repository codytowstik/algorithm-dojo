package main.classics.recursion.complexity_analysis.mypow;

/**
 * Pow. Recursive solution.
 *
 *  Time: O(logn)
 * Space: O(logn)
 */
public class MyPow1 extends MyPow
{
	@Override
	public double myPow(double x, int n)
	{
		// -2147483648 (max_negative_int) is negative again, when multiplied by one
		long N = n;

		if (N == 0)
		{
			return 1;
		}

		else if (N < 0)
		{
			// x^-2 == 1/x^2
			x = 1 / x;
			N = -N;
		}


		// multiply one more time since we had to increment MAX_NEGATIVE_INT by 1
		return helper(x, N);
	}

	public double helper(double x, long n)
	{
		// we can save time and not calculate all values
		// x^n * x^n = (x^n)^2
		// we can save time by not calculating each iteration of x^n twice
		// x^8 => x^4 * x^2 * x^2
		// x^9 => x * x^8

		// base case - x^1 = x

		if (n == 1)
		{
			return x;
		}

		double 	half = helper(x, n / 2);

		if (n % 2 == 0)
		{
			return half * half;
		}
		else
		{
			return x * half * half;
		}
	}
}
