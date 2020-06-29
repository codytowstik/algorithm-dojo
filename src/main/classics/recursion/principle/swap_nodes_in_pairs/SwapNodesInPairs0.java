package main.classics.recursion.principle.swap_nodes_in_pairs;

import main.data_structures.ListNode;

/**
 * Swap nodes.
 *
 * Recursive. In place.
 *
 * Space: 0
 * Runtime: O(n)
 */
public class SwapNodesInPairs0 extends SwapNodesInPairs
{
	@Override
	public ListNode swapPairs(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		// Recurse all the way down

		// re-attach the head we are swapping to subsequent pair swaps
		head.next.next = swapPairs(head.next.next);

		// Swap on backtracking

		// save the current 'next' node since we are about to write over it
		ListNode 	newHead = head.next;

		// set the current head's next to the new head's next
		head.next = newHead.next;

		// set new head's next to current head
		newHead.next = head;

		return newHead;
	}
}
