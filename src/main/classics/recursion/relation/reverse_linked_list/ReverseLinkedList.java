package main.classics.recursion.relation.reverse_linked_list;

import main.data_structures.ListNode;
import main.utils.Solution;
import main.utils.SolutionInput;

public abstract class ReverseLinkedList implements Solution
{
	public Object execute(SolutionInput input)
	{
		ListNode 	head = (ListNode) input.getFirstInput();

		return reverseList(head);
	}

	public abstract ListNode reverseList(ListNode head);
}
