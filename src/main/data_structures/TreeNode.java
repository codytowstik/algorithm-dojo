package main.data_structures;

public class TreeNode
{
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x)
	{
		val = x;
	}

	public TreeNode(int val, TreeNode left, TreeNode right)
	{
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public void setLeft(TreeNode left)
	{
		this.left = left;
	}

	public void setRight(TreeNode right)
	{
		this.right = right;
	}
}
