package main.classics.recursion.principle;

import main.TestBase;
import main.data_structures.ListNode;
import main.data_structures.ListNodeUtils;
import org.junit.jupiter.api.Test;

public class SwapNodesInPairsTest extends TestBase
{
	@Test
	public void testSwapNodesInPairs0()
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

		ListNodeUtils.printRemainingNodes(headNode);
	}
}
