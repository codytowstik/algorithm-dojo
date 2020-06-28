package main.data_structures;

import main.utils.ComplexResultStringBuilder;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class TreeNodeUtils
{
	private TreeNodeUtils()
	{
		// disallow instantiation
	}

	public static String buildRemainingNodesString(TreeNode root)
	{
		ComplexResultStringBuilder complexResultStringBuilder = new ComplexResultStringBuilder(" -> ");

		addTreeNodesToPrinterBFS(root, complexResultStringBuilder);

		complexResultStringBuilder.buildResultStringMultiLine();

		return complexResultStringBuilder.getLatestResultString();
	}

	private static void addTreeNodesToPrinterBFS(TreeNode treeNode, ComplexResultStringBuilder complexResultStringBuilder)
	{
		LinkedList<TreeNode> 	nodeQueue = new LinkedList<>();

		Set<Integer> 			seenValues = new HashSet<>();

		int 					depth = 1;

		nodeQueue.add(treeNode);
		seenValues.add(treeNode.val);
		complexResultStringBuilder.addItem(treeNode.val);
		complexResultStringBuilder.incrementRow();

		while (!nodeQueue.isEmpty())
		{
			TreeNode 	currentNode = nodeQueue.pop();

			// enqueue (add at end)
			// if we haven't seen the value yet, add it to our queue
			if (currentNode.left != null && !seenValues.contains(currentNode.left.val))
			{
				nodeQueue.add(currentNode.left);
				seenValues.add(currentNode.left.val);

				// add visited node value to printer

				complexResultStringBuilder.addItem(currentNode.left.val);
			}

			if (currentNode.right != null && !seenValues.contains(currentNode.right.val))
			{
				nodeQueue.add(currentNode.right);
				seenValues.add(currentNode.right.val);

				// add visited node value to printer

				complexResultStringBuilder.addItem(currentNode.right.val);
			}

			if (currentNode.left != null || currentNode.right != null)
			{
				depth++;
				complexResultStringBuilder.incrementRow();
			}
		}

		complexResultStringBuilder.addItem(MessageFormat.format("\n\nDepth: {0}", depth));
	}

	public static boolean compareTreeNodesDFS(TreeNode treeNode1, TreeNode treeNode2)
	{
		// if both nodes aren't null, they are unequal
		if ((treeNode1 == null && treeNode2 != null ) ||
			(treeNode2 == null && treeNode1 != null))
		{
			return false;
		}
		else if (treeNode1 == null && treeNode2 == null)
		{
			return true;
		}

		boolean 	leftResult = compareTreeNodesDFS(treeNode1.left, treeNode2.left);
		boolean 	rightResult = compareTreeNodesDFS(treeNode1.right, treeNode2.right);

		return leftResult && rightResult;
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
