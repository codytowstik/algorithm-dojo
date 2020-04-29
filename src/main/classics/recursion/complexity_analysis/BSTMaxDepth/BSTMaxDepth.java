package main.classics.recursion.complexity_analysis.BSTMaxDepth;

import main.data_structures.TreeNode;
import main.utils.Solution;
import main.utils.SolutionInput;

public abstract class BSTMaxDepth implements Solution
{
	@Override
	public Object execute(SolutionInput input)
	{
		TreeNode 	root = (TreeNode) input.getFirstInput();

		return maxDepth(root);
	}

	public abstract int maxDepth(TreeNode root);
}
