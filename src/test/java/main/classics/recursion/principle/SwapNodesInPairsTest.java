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
		ListNode 	headNodeExpected = new ListNode(2);
		ListNode 	node1Expected  = new ListNode(1);
		ListNode 	node2Expected  = new ListNode(4);
		ListNode 	node3Expected  = new ListNode(3);

		headNodeExpected.setNext(node1Expected);
		node1Expected.setNext(node2Expected);
		node2Expected.setNext(node3Expected);

		ListNode 	headNode = new ListNode(1);
		ListNode 	node1 = new ListNode(2);
		ListNode 	node2 = new ListNode(3);
		ListNode 	node3 = new ListNode(4);

		// head -> node1 	-> node2 	-> node3
		// 1	-> 2 		-> 3 		-> 4

		headNode.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);

		ListNodeUtils.printRemainingNodes(headNodeExpected);
		ListNodeUtils.printRemainingNodes(headNode);

		assertEquals(headNodeExpected, headNode);
	}
}
