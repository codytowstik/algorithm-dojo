package main.classics.recursion.principle.reverse_string;

import main.utils.Solution;
import main.utils.SolutionInput;

/**
 * https://leetcode.com/explore/featured/card/recursion-i/250/principle-of-recursion/1440/
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 */
public abstract class ReverseString implements Solution
{
	public Object execute(SolutionInput input)
	{
		char[] 		str = (char[]) input.getFirstInput();

		reverseString(str);

		return null;
	}

	abstract void reverseString(char[] str);
}
