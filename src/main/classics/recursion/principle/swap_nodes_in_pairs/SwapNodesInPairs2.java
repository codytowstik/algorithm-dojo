package main.classics.recursion.principle.swap_nodes_in_pairs;

import main.data_structures.ListNode;

/**
 * Swap nodes. Same as the 1th solution, but spelled out
 *
 * Recursive. In place.
 *
 * Space: 0
 * Runtime: O(n)
 */
public class SwapNodesInPairs2 extends SwapNodesInPairs
{
	@Override
	public ListNode swapPairs(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		// Save the nodes to be swapped
		ListNode	firstNode = head;
		ListNode	secondNode = head.next;

		// Swap the nodes

		// Recurse down, making the new tail point to the rest of the sub-problem
		firstNode.next = swapPairs(secondNode.next);

		// backtracking, swap
		secondNode.next = firstNode;

		return secondNode;
	}
}
