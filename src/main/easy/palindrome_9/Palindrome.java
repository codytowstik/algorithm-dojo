package main.easy.palindrome_9;

import main.utils.SolutionEx;

public abstract class Palindrome implements SolutionEx
{
	public Object execute(int input)
	{
		return isPalindrome(input);
	}

	abstract boolean isPalindrome(int input);
}
