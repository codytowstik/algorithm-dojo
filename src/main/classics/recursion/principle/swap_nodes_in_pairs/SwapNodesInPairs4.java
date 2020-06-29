package main.classics.recursion.principle.swap_nodes_in_pairs;

import main.data_structures.ListNode;

/**
 * Swap nodes.
 *
 * Interesting iterative approach, using a dummy node to track the original head of the list.
 *
 * Space: 1
 * Runtime: O(n)
 */
public class SwapNodesInPairs4 extends SwapNodesInPairs
{
	@Override
	public ListNode swapPairs(ListNode head)
	{
		// Dummy node acts as the prevNode for the head node
		// of the list and hence stores pointer to the head node.
		ListNode 	dummy = new ListNode(-1);
		dummy.next = head;

		ListNode 	prevNode = dummy;

		while ((head != null) && (head.next != null))
		{
			// Nodes to be swapped
			ListNode 	firstNode = head;
			ListNode 	secondNode = head.next;

			// Swapping
			prevNode.next = secondNode;
			firstNode.next = secondNode.next;
			secondNode.next = firstNode;

			// Reinitializing the head and prevNode for next swap
			prevNode = firstNode;
			head = firstNode.next; // jump
		}

		// Return the new head node.
		return dummy.next;

	}
}
