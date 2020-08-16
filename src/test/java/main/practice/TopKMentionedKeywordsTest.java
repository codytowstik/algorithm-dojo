package main.practice;


import main.practice.top_k_mentioned_keywords.TopKMentionedKeywords;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public final class TopKMentionedKeywordsTest
{
	@Test
	public void testTopKMentionedKeywords()
	{
		int k = 2;
		String[] reviews = new String[]{
			"Anacell provides the best services in the city",
			"betacellular has awesome services",
			"Best services provided by anacell, everyone should use anacell",
		};

		String[] keywords = new String[]{"anacell", "cetracular", "betacellular"};

		String[] output = new String[]{"anacell", "betacellular"};

		String[] result = TopKMentionedKeywords.findTopK(reviews, keywords, k);

		System.out.println(Arrays.toString(result));

		int k1 = 2;
		String[] reviews1 = new String[]{"I love anacell Best services; Best services provided by anacell",
			"betacellular has great services",
			"deltacellular provides much better services than betacellular",
			"cetracular is worse than anacell",
			"Betacellular is better than deltacellular."};

		String[] keywords1 = new String[]{"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};

		String[] output1 = new String[]{"betacellular", "anacell"};

		String[] result1 = TopKMentionedKeywords.findTopK(reviews1, keywords1, k);

		System.out.println(Arrays.toString(result1));
	}
}
