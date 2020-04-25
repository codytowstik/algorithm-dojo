package main.data_structures;

import main.utils.Printer;

public final class TreeNodeUtils
{
	private TreeNodeUtils()
	{
		// disallow instantiation
	}

	public static String buildRemainingNodesString(TreeNode root)
	{
		Printer 	printer = new Printer(" -> ");

		addTreeNodesToPrinter(root, printer);

		printer.buildResultString();

		return printer.getLatestResultString();
	}

	private static void addTreeNodesToPrinter(TreeNode treeNode, Printer printer)
	{
		if (treeNode == null)
		{
			return;
		}

		printer.addItem(treeNode);

		addTreeNodesToPrinter(treeNode.left, printer);
		addTreeNodesToPrinter(treeNode.right, printer);
	}
	
	public static void printRemainingNodes(TreeNode head)
	{
		String 		result = buildRemainingNodesString(head);

		System.out.println(result);
	}

	/**
	 * Check that the head and subsequent children are equivalent.
	 *
	 * @param head1 head1
	 * @param head2 head2
	 * @return true if each item is equal, in order
	 */
	public static boolean isEquals(TreeNode head1, TreeNode head2)
	{
		return (getIndexOfFirstInequality(head1, head2) > 0);
	}

	/**
	 * Get the first index of inequality for values in children.
	 *
	 * @param head1 head1
	 * @param head2 head2
	 * @return the index of first inequality, or -1 if equal
	 */
	public static int getIndexOfFirstInequality(TreeNode head1, TreeNode head2)
	{
		int			indexOfFirstInequality = -1;

		TreeNode 	currentNode1 = head1;
		TreeNode 	currentNode2 = head2;

		int			currentIndex = 0;

		while ((currentNode1 != null) && (currentNode2 != null))
		{
			int 	currentValue1 = currentNode1.val;
			int 	currentValue2 = currentNode2.val;

			boolean isEquals = currentValue1 == currentValue2;

			if (!isEquals)
			{
				indexOfFirstInequality = currentIndex;
				break;
			}

			// currentNode1 = currentNode1.next;
			// currentNode2 = currentNode2.next;

			++currentIndex;
		}

		// if they are different lengths, return -2

		if (((currentNode1 == null) && (currentNode2 != null)) ||
			((currentNode1 != null) && (currentNode2 == null)))
		{
			return -2;
		}

		return indexOfFirstInequality;
	}
}
