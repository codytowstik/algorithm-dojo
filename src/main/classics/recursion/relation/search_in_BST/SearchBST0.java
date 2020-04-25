package main.classics.recursion.relation.search_in_BST;

import main.data_structures.TreeNode;

public class SearchBST0 extends SearchBST
{
	@Override
	public TreeNode searchBST(TreeNode root, int val)
	{
		if (root == null || root.val == val)
		{
			return root;
		}

		TreeNode 	result = searchBST(root.left, val);

		if (result == null)
		{
			result = searchBST(root.right, val);;
		}

		return result;
	}
}
