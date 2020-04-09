package main.easy.reverse_integer_7;

import main.utils.SolutionEx;
import main.utils.SolutionInput;

public abstract class ReverseInteger implements SolutionEx
{
	public Object execute(SolutionInput solutionInput)
	{
		int 	num = (int) solutionInput.getFirstInput();

		return reverseInteger(num);
	}

	abstract int reverseInteger(int x);
}
