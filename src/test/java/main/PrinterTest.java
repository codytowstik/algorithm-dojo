package main;

import main.data_structures.ListNode;
import main.data_structures.ListNodeUtils;
import main.utils.Printer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class PrinterTest
{
	@Test
	public void testListNodePrinter()
	{
		ListNode 	headNode = new ListNode(0);
		ListNode 	node1 = new ListNode(1);
		ListNode 	node2 = new ListNode(2);
		ListNode 	node3 = new ListNode(3);
		ListNode 	node4 = new ListNode(4);

		// head -> node1 	-> node2 	-> node3 	-> node4
		// 0	-> 1		-> 2 		-> 3 		-> 4
		headNode.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);

		String 		printedResult = ListNodeUtils.buildRemainingNodesString(headNode);

		Assertions.assertEquals("0 -> 1 -> 2 -> 3 -> 4", printedResult);
	}
}
