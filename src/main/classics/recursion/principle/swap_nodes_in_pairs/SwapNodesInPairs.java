package main.classics.recursion.principle.swap_nodes_in_pairs;

import main.utils.Solution;
import main.utils.SolutionInput;

public abstract class SwapNodesInPairs implements Solution
{
	public Object execute(SolutionInput input)
	{
		char[] str = (char[]) input.getFirstInput();

		swapNodes(str);

		return null;
	}

	abstract void swapNodes(char[] str);
}
