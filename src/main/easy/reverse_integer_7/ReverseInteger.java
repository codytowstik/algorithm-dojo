package main.easy.reverse_integer_7;

import main.utils.SolutionEx;

public abstract class ReverseInteger implements SolutionEx
{
	public Object execute(int input)
	{
		return reverseInteger(input);
	}

	abstract int reverseInteger(int x);
}
