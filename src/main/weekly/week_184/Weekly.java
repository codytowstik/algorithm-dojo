package main.weekly.week_184;

import main.utils.Solution;
import main.utils.SolutionInput;

public abstract class Weekly implements Solution
{
	public Object execute(SolutionInput input)
	{
		int[] 	values = (int[]) input.getInputAtIndex(0);
		int 	valueToFind = (int) input.getInputAtIndex(1);

		return findIndexOfNumber(values, valueToFind);
	}

	abstract int findIndexOfNumber(int[] values, int valueToFind);
}
