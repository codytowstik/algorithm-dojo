package main.classics.recursion.principle.reverse_string;

public class ReverseStringCleaned extends ReverseString
{
	public void reverseString(char[] str)
	{
		helper(str.length - 1, 0, str);
	}

	private void helper(int hi, int lo, char[] str)
	{
		if (hi <= lo)
		{
			return;
		}

		char c = str[lo];

		str[lo] = str[hi];

		str[hi] = c;

		helper(--hi, ++lo, str);
	}
}
