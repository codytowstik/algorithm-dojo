package main.classics.recursion.principle.swap_nodes_in_pairs;

import main.data_structures.ListNode;

/**
 * Swap nodes. Same as the 0th solution, except in a more sensible order
 *
 * Recursive. In place.
 *
 * Space: 0
 * Runtime: O(n)
 */
public class SwapNodesInPairs1 extends SwapNodesInPairs
{
	@Override
	public ListNode swapPairs(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		// swap the first two nodes

		// ListNode		nextPairHead = head.next.next;

		ListNode	newHead = head.next;

		head.next = newHead.next;

		newHead.next = head;

		// call swap on the head of the next pair
		// attach the next subsequent pairs to the new tail

		head.next = swapPairs(head.next);

		return newHead;
	}
}
