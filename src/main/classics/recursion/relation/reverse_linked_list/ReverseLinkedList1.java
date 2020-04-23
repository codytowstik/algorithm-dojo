package main.classics.recursion.relation.reverse_linked_list;

import main.data_structures.ListNode;

/**
 * Reverse Linked List.
 *
 * Iterative.
 *
 * Runtime: O(n)
 * Space: O(1)
 */
public class ReverseLinkedList1 extends ReverseLinkedList
{
	@Override
	public ListNode reverseList(ListNode head)
	{
		ListNode	prev = null;
		ListNode	current = head;

		while (current != null)
		{
			// swap next pointer
			ListNode 	nextTemp = current.next;

			current.next = prev;

			// increment to original next pointer
			prev = current;

			current = nextTemp;
		}

		return prev;
	}
}
