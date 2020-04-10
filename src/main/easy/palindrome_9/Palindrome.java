package main.easy.palindrome_9;

import main.utils.Solution;
import main.utils.SolutionInput;

public abstract class Palindrome implements Solution
{
	public Object execute(SolutionInput input)
	{
		int 	castedInput = (int) input.getInputAtIndex(0);

		return isPalindrome(castedInput);
	}

	abstract boolean isPalindrome(int input);
}
