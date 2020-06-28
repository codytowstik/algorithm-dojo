package main.classics.recursion.complexity_analysis.BSTMaxDepth;

import main.data_structures.TreeNode;
import main.utils.Solution;
import main.utils.SolutionInput;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2375/
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 *
 */
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
