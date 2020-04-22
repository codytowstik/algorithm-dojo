package main.classics.recursion.principle.reverse_string;

/**
 * Reverse String.
 *
 * Brute force.
 *
 * Move all items into temp array in reverse order. Iterate through temp array and set the values of original array to temp array values.
 *
 * Space: O(n)
 * Runtime: N (initial iteration) + N (setting values) = O(n)
 */
public class ReverseString0 extends ReverseString
{
	public void reverseString(char[] str)
	{
		char[] 		temp = new char[str.length];

		for (int i = 0; i < str.length; i++)
		{
			int reverseIndex = str.length - 1 - i;

			temp[i] = str[reverseIndex];
		}

		for (int i = 0; i < str.length; i++)
		{
			str[i] = temp[i];
		}
	}
}
