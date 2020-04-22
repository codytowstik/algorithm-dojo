package main.classics.recursion.principle.reverse_string;

/**
 * Reverse String.
 *
 * Recursion impl.
 */
public class ReverseString1 extends ReverseString
{
	public void reverseString(char[] str)
	{
		int 	hi = str.length - 1;
		int 	lo = 0;

		helper(hi, lo, str);
	}

	private void helper(int hi, int lo, char[] str)
	{
		if (hi <= lo)
		{
			return;
		}

		char 	charToSwitch = str[lo];

		str[lo] = str[hi];

		str[hi] = charToSwitch;

		helper(--hi, ++lo, str);
	}
}
