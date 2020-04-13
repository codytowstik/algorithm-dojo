package main.weekly.week_184;

import org.junit.jupiter.api.Test;

import java.util.*;

public final class StringMatchingArrayTest
{
	@Test
	public void testStringMatchingArray()
	{
		String[] 		input1 = new String[]{"mass", "as", "hero", "superhero"};

		List<String> 	output1 = new ArrayList<>()
		{{
			add("as");
			add("hero");
		}};

		String[] 		input2 = new String[]{"leetcode", "et", "code"};

		List<String> 	output2 = new ArrayList<>()
		{{
			add("et");
			add("code");
		}};

		String[] 		input3 = new String[]{"blue", "green", "bu"};

		List<String> 	output3 = new ArrayList<>();

		String[] 		input4 = new String[]{"leetcoder", "leetcode", "od", "hamlet", "am"};

		List<String> 	output4 = new ArrayList<>()
		{{
			add("leetcode");
			add("od");
			add("am");
		}};

		// boolean result1 = stringMatching1(input1).equals(output1);
		// boolean result2 = stringMatching1(input2).equals(output2);
		// boolean result3 = stringMatching1(input3).equals(output3);
		boolean result4 = stringMatching1(input4).equals(output4);

		// assert result1;
		// assert result2;
		// assert result3;
		assert result4;
	}

	public List<String> stringMatching1(String[] words)
	{
		List<String>	result = new ArrayList<>();

		// for each word,
		//  check each other word and see if it is a substring

		for (int i = 0; i < words.length; i++)
		{
			String 		firstWord = words[i];

			for (int j = 0; j < words.length; j++)
			{
				if (i != j)
				{
					String 		secondWord = words[j];

					if (secondWord.contains(firstWord))
					{
						result.add(firstWord);
						break;
					}
				}
			}
		}

		return result;
	}

	// public List<String> stringMatching2(String[] words)
	// {
	// 	Set<String> 	ourWords = new HashSet(Arrays.asList(words));
	//
	// 	// for each word,
	// 	//  check each other word and see if it is a substring
	//
	// 	for (int i = 0; i < words.length; i++)
	// 	{
	// 		String firstWord = words[i];
	//
	// 		for (int j = 0; j < words.length; j++)
	// 		{
	// 			if (i != j)
	// 			{
	// 				String secondWord = words[j];
	//
	// 				if (secondWord.contains(firstWord))
	// 				{
	// 					result.add(firstWord);
	// 				}
	// 			}
	// 		}
	// 	}
	//
	// 	return result;
	// }
}
