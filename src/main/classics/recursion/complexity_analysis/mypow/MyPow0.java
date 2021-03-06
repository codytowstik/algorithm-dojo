package main.classics.recursion.complexity_analysis.mypow;

/**
 * Pow. Recursive solution without converting 'n' to long.. pretty nasty
 *
 *  Time: O(logn)
 * Space: O(logn)
 */
public class MyPow0 extends MyPow
{
	@Override
	public double myPow(double x, int n)
	{
		// -2147483648 (max_negative_int) is negative again, when multiplied by one
		double max_negative_helper;


		if (n == -2147483648)
		{
			max_negative_helper = 1 / x;

			++n;
		}
		else
		{
			max_negative_helper = 1;
		}

		if (n == 0)
		{
			return 1;
		}

		else if (n < 0)
		{
			// x^-2 == 1/x^2
			x = 1 / x;
			n = -n;
		}


		// multiply one more time since we had to increment MAX_NEGATIVE_INT by 1
		return max_negative_helper * helper(x, n);
	}

	public double helper(double x, int n)
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

		double half = helper(x, n / 2);

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
