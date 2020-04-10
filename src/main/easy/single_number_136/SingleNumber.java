package main.easy.single_number_136;

import main.utils.Solution;
import main.utils.SolutionInput;

public abstract class SingleNumber implements Solution
{
	public Object execute(SolutionInput solutionInput)
	{
		int[] 	num = (int[]) solutionInput.getFirstInput();

		return singleNumber(num);
	}

	abstract int singleNumber(int[] input);
}
