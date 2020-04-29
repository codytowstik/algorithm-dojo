package main.classics.recursion.complexity_analysis.mypow;

import main.utils.Solution;
import main.utils.SolutionInput;

public abstract class MyPow implements Solution
{
	@Override
	public Object execute(SolutionInput input)
	{
		double 	x = (double) input.getFirstInput();

		int		n = (int) input.getInputAtIndex(1);

		return myPow(x, n);
	}

	public abstract double myPow(double x, int n);
}
