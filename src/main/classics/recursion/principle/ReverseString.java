package main.classics.recursion.principle;

import main.utils.Solution;
import main.utils.SolutionInput;

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
