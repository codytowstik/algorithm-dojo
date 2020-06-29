package main.classics.recursion.principle.swap_nodes_in_pairs;

import main.data_structures.ListNode;

/**
 * Swap nodes.
 *
 * Hideous iterative approach.
 *
 * Space: 1
 * Runtime: O(n) - n is size of linked list
 */
public class SwapNodesInPairs3 extends SwapNodesInPairs
{
	@Override
	public ListNode swapPairs(ListNode head)
	{
		// check for empty or single sized arrays
		ListNode 	finalHead = head != null ? (head.next != null ? head.next : head) : null;

		while ((head != null) && (head.next != null))
		{
			// Nodes to be swapped
			ListNode 	firstNode = head;
			ListNode 	secondNode = head.next;

			// Swapping, accounting for the next swap by
			// .. pointing the new tail at the second of the next pair
			// .. or the last remaining, if there is only 1 left
			// .. else null
			firstNode.next = secondNode.next != null ? (secondNode.next.next != null ? secondNode.next.next : secondNode.next) : null;

			ListNode 	nextPairHead = secondNode.next;

			secondNode.next = firstNode;

			// jump
			head = nextPairHead;
		}

		// Return the new head node.
		return finalHead;
	}
}
