package main.practice.top_k_mentioned_keywords;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode.com/discuss/interview-question/542597/
 *
 * Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.
 *
 * - The comparison of strings is case-insensitive.
 * - Multiple occurrences of a keyword in a review should be considered as a single mention.
 * - If keywords are mentioned an equal number of times in reviews, sort alphabetically.
 *
 * Input:
 * k = 2
 * keywords = ["anacell", "cetracular", "betacellular"]
 * reviews = [
 *   "Anacell provides the best services in the city",
 *   "betacellular has awesome services",
 *   "Best services provided by anacell, everyone should use anacell",
 * ]
 *
 * Output:
 * ["anacell", "betacellular"]
 *
 * Explanation:
 * "anacell" is occurring in 2 different reviews and "betacellular" is only occuring in 1 review.
 *
 * Areas to improve:
 * - Keep given keywords in a set, only add seen words to the map so we don't need to add zero-valued counts to the queue
 */
public class TopKMentionedKeywords0
{
	public static String[] findTopK(
		String[] 	reviews,
		String[] 	keywords,
		int 		k)
	{
		String[] results = new String[k];

		// how many reviews does a keyword appear in, case insensitive

		// for each review
			// check if each word is a keyword we haven't seen before
				// -- need each keyword stored in a set
				// -- need each 'seen' keyword stored in a set, emptied for each review

				// if yes, increment the counter for that keyword, and track having seen it for this review

		// 'keywordCount' map of each keyword for constant access time, initialize as 0
		Map<String,Integer> keywordCount = new HashMap<>(keywords.length);

		print("Keywords:");
		for (String keyword : keywords)
		{
			keywordCount.put(keyword.toLowerCase(), 0);
			print("{0}", keyword);
		}

		// for each review
		for (String review : reviews)
		{
			print("");
			print("review: {0}", review);
			// new set for 'seenKeywords'
			Set<String> seenKeywords = new HashSet<>();

			// for each word in the review
			for (String word : review.split(" "))
			{
				String lowerWord = word.toLowerCase();
				// is (lower-cased) word in keyword map && not in 'seenKeywords' set
				if (keywordCount.containsKey(lowerWord) && !seenKeywords.contains(lowerWord))
				{
					print("- counting: {0}", lowerWord);
					// increment seen count in
					int count = keywordCount.get(lowerWord);

					keywordCount.put(lowerWord, ++count);

					// add lower-cased word to 'seenKeywords' set
					seenKeywords.add(lowerWord);
				}
			}
		}

		print("");
		print("Entry set:");
		print("{0}", Arrays.toString(keywordCount.entrySet().toArray()));

		// new PriorityQueue minheap - comparator for smallest values first, otherwise alphabetically higher goes second
		// (so when we pop values off they are in the correct order

		// new PriorityQueue maxHeap - comparator for larger values first, otherwise alphabetically higher goes first
		PriorityQueue<String> maxHeap = new PriorityQueue<>(keywordCount.size(), (word1, word2) -> keywordCount.get(word1) != keywordCount.get(word2) ? keywordCount.get(word2).compareTo(keywordCount.get(word1)) : word1.compareTo(word2));

		maxHeap.addAll(keywordCount.keySet());
		// for each entry in 'keywordCount'
		// add entry to priority queue

		for (int i = 0; i < k; i++)
		{
			results[i] = maxHeap.poll();
		}

		// pop off 'k' values into results


		return results;
	}

	private static void print(String message)
	{
		print(message, null);
	}

	private static void print(String message, Object o1)
	{
		String messageFormatted = MessageFormat.format(message, o1);

		System.out.println(messageFormatted);
	}
}
