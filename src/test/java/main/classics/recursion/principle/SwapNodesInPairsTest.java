package main.classics.recursion.principle;

import main.TestBase;
import main.classics.recursion.principle.swap_nodes_in_pairs.SwapNodesInPairs0;
import main.data_structures.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SwapNodesInPairsTest extends TestBase
{
	@Test
	public void testSwapNodesInPairs0()
	{
		ListNode 	headNodeExpected = new ListNode(2);
		ListNode 	node1Expected  = new ListNode(1);
		ListNode 	node2Expected  = new ListNode(4);
		ListNode 	node3Expected  = new ListNode(3);

		headNodeExpected.setNext(node1Expected);
		node1Expected.setNext(node2Expected);
		node2Expected.setNext(node3Expected);

		ListNode 	headNode = new ListNode(1);
		ListNode 	node1 = new ListNode(2);
		ListNode 	node2 = new ListNode(3);
		ListNode 	node3 = new ListNode(4);

		// head -> node1 	-> node2 	-> node3
		// 1	-> 2 		-> 3 		-> 4

		headNode.setNext(node1);
		node1.setNext(node2);
		node2.setNext(node3);

		SwapNodesInPairs0 	swapNodesInPairs0 = new SwapNodesInPairs0();

		ListNode 			resultHead = swapNodesInPairs0.swapPairs(headNode);

		assertEquals(headNodeExpected, resultHead);
	}

	@Test
	public void testStuff()
	{
		System.out.println((-2147483648 + 1) * -1);
		System.out.println(Math.abs(-2147483648));

		Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

		// Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
	}

	public List<String> topKFrequent(String[] words, int k)
	{
		Map<String, Integer> 	count = new HashMap();

		for (String word : words)
		{
			count.put(word, count.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<String> heap = new PriorityQueue<>(
			(w1, w2) -> {
				return count.get(w1).equals(count.get(w2)) ?
					w2.compareTo(w1) : count.get(w1) - count.get(w2);
			});

		for (String word : count.keySet())
		{
			System.out.println(heap.toString());
			heap.offer(word);

			if (heap.size() > k)
			{
				String polled = heap.poll();

				System.out.println(polled);
			}
		}

		List<String> ans = new ArrayList();

		while (!heap.isEmpty()) ans.add(heap.poll());
		Collections.reverse(ans);
		return ans;
	}

	@Test
	public void testK()
	{
		String[] testArray = new String[]{"i", "love", "love", "leetcode", "i", "love", "coding"};

		topKFrequent(testArray, 3);
	}
}