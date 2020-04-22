package main.classics.recursion.principle.swap_nodes_in_pairs;

import main.data_structures.ListNode;
import main.utils.Solution;
import main.utils.SolutionInput;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 */
public abstract class SwapNodesInPairs implements Solution
{
	public Object execute(SolutionInput input)
	{
		ListNode head = (ListNode) input.getFirstInput();

		swapPairs(head);

		return null;
	}

	abstract void swapPairs(ListNode head);
}
