package main.data_structures;

import main.utils.Printer;

public final class ListNodeUtils
{
	private ListNodeUtils()
	{
		// disallow instantiation
	}

	public static Printer printRemainingNodes(ListNode head)
	{
		Printer 	printer = new Printer(" -> ");

		printer.addItem(head.val);

		ListNode	currentNode = head.next;

		while (currentNode != null)
		{
			printer.addItem(currentNode.val);

			currentNode = currentNode.next;
		}

		printer.buildAndPrintResult();

		// return printer so we can debug results

		return printer;
	}

	/**
	 * Check that the head and subsequent values in 'next' are equivalent.
	 *
	 * @param head1 head1
	 * @param head2 head2
	 * @return true if each item is equal, in order
	 */
	public static boolean isEquals(ListNode head1, ListNode head2)
	{
		boolean		isEquals = true;
		ListNode	currentNode1 = head1;
		ListNode	currentNode2 = head2;

		while ((currentNode1 != null) && (currentNode2 != null))
		{
			int 	currentValue1 = currentNode1.val;
			int		currentValue2 = currentNode2.val;

			isEquals &= (currentValue1 == currentValue2);

			if (!isEquals)
			{
				break;
			}

			currentNode1 = currentNode1.next;
			currentNode2 = currentNode2.next;
		}

		return isEquals;
	}
}
