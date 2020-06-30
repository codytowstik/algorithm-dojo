package main.classics.recursion.complexity_analysis.BSTMaxDepth;

import main.data_structures.TreeNode;

/**
 * This is wrong. The base case should be "I am null".
 */
public class BSTMaxDepth0 extends BSTMaxDepth
{
	@Override
	public int maxDepth(TreeNode root)
	{
		return helper(root, 0);
	}

	private int helper(TreeNode root, int currentDepth)
	{
		if (root.left == null && root.right == null)
		{
			return currentDepth;
		}

		int 	maxLeft = 0;

		if (root.left != null)
		{
			maxLeft = helper(root.left, currentDepth + 1);
		}

		int 	maxRight = 0;

		if (root.right != null)
		{
			maxRight = helper(root.right, currentDepth + 1);
		}

		int 	max = (maxLeft > maxRight) ? maxLeft : maxRight;

		return max;
	}
}
