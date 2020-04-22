package main.classics.recursion.principle.swap_nodes_in_pairs;

import main.data_structures.ListNode;

public class SwapNodesInPairs0 extends SwapNodesInPairs
{
	@Override
	public ListNode swapPairs(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		// re-attach the head we are swapping to subsequent pair swaps

		head.next.next = swapPairs(head.next.next);

		// set new head to next node
		ListNode 	newHead = head.next;

		// set previous head's next, to new head's old next
		head.next = newHead.next;

		// set new head's next to previous head
		newHead.next = head;

		return newHead;
	}
}
