package main.classics.recursion.relation.search_in_BST;

import main.data_structures.TreeNode;
import main.utils.Solution;
import main.utils.SolutionInput;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3233/
 *
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 *
 * For example,
 *
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * And the value to search: 2
 * You should return this subtree:
 *
 *       2
 *      / \
 *     1   3
 * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
 *
 * Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 */
public abstract class SearchBST implements Solution
{
	public Object execute(SolutionInput input)
	{
		TreeNode	root = (TreeNode) input.getFirstInput();

		int			val = (int) input.getInputAtIndex(1);

		return searchBST(root, val);
	}

	public abstract TreeNode searchBST(TreeNode root, int val);
}
