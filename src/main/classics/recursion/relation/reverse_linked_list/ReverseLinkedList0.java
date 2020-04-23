package main.classics.recursion.relation.reverse_linked_list;

import main.data_structures.ListNode;

/**
 * Reverse Linked List.
 *
 * Recursive.
 *
 * Runtime: O(n)
 * Space: O(n) - implicit stack space due to recursion
 */
public class ReverseLinkedList0 extends ReverseLinkedList
{
	@Override
	public ListNode reverseList(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		ListNode 	finalNode = reverseList(head.next);

		head.next.next = head;
		head.next = null;


		return finalNode;
	}

	// 1 -> 2 -> 3 -> 4
	//
	//    reverse(2)
	//        reverse(3)
	//            reverse(4)
	//            return 4
	//       4 -> 3
	//       3 -> null
	//       return 4
	//    3 -> 2
	//    2 -> null
	//    return 4
	//
	// 2 -> 1
	// 1 -> null
}
