package main.classics.recursion.relation;

import main.TestBase;
import main.classics.recursion.relation.reverse_linked_list.ReverseLinkedList1;
import main.data_structures.ListNode;
import org.junit.jupiter.api.Test;

public final class ReverseLinkedListTest extends TestBase
{
	// TODO: automate test

	@Test
	public void testReverseLinkedList1()
	{
		ListNode 	headNodeExpected = new ListNode(4);
		ListNode 	node1Expected  = new ListNode(3);
		ListNode 	node2Expected  = new ListNode(2);
		ListNode 	node3Expected  = new ListNode(1);

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

		ReverseLinkedList1 	ReverseLinkedList1 = new ReverseLinkedList1();

		ListNode 			resultHead = ReverseLinkedList1.reverseList(headNode);

		assertEquals(headNodeExpected, resultHead);
	}
}
