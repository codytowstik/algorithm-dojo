package main.easy.palindrome_9;

import main.utils.SolutionEx;

public abstract class Palindrome implements SolutionEx
{
	public Object execute(Object input)
	{
		return isPalindrome((int) input);
	}

	abstract boolean isPalindrome(int input);
}
