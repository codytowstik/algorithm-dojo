package main.classics.recursion.complexity_analysis.BSTMaxDepth;

import main.data_structures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * BST Max Depth. Iterative solution using BFS.
 *
 *  Time: O(n) - we visit each node once
 * Space: O(n) - tree isn't guaranteed to be balanced so all nodes could be down one side
 */
public class BSTMaxDepth2 extends BSTMaxDepth
{
	@Override
	public int maxDepth(TreeNode root)
	{
		if (root == null)
		{
			return 0;
		}

		Deque<TreeNode> 	dq = new ArrayDeque<>();
		int 				depth = 0;
		int 				next = 0;
		TreeNode 			current;

		dq.offer(root);

		while (!dq.isEmpty())
		{
			depth++;
			next = dq.size();

			for (int i = 0; i < next; ++i)
			{
				current = dq.poll();

				if (current.left != null)
				{
					dq.offer(current.left);
				}

				if (current.right != null)
				{
					dq.offer(current.right);
				}
			}
		}

		return depth;
	}
}
