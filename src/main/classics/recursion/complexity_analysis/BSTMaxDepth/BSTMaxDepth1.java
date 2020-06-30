package main.classics.recursion.complexity_analysis.BSTMaxDepth;

import main.data_structures.TreeNode;

/**
 * BST Max Depth. Recursive solution.
 *
 *  Time: O(n) - we visit each node once
 * Space: O(n) - tree isn't guaranteed to be balanced so all nodes could be down one side
 */
public class BSTMaxDepth1 extends BSTMaxDepth
{
	@Override
	public int maxDepth(TreeNode root)
	{
		return helper(0, root);
	}

	public int helper(int currentDepth, TreeNode root)
	{
		// base case
		if (root == null)
		{
			return currentDepth;
		}
		else
		{
			++currentDepth;
		}

		int 	maxDepthRightSide = helper(currentDepth, root.right);

		int 	maxDepthLeftSide = helper(currentDepth, root.left);

		int 	maxDepth = (maxDepthRightSide > maxDepthLeftSide) ? maxDepthRightSide : maxDepthLeftSide;

		return maxDepth;
	}
}
