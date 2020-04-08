package main.easy.palindrome_9;

import main.utils.SolutionEx;
import main.utils.SolutionInput;

public abstract class Palindrome implements SolutionEx
{
	public Object execute(SolutionInput input)
	{
		int castedInput = (int) input.getInputAtIndex(0);

		return isPalindrome(castedInput);
	}

	abstract boolean isPalindrome(int input);
}
