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
}
