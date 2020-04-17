package main.easy.string_matching_array_1408;

import java.util.ArrayList;
import java.util.List;

public final class StringMatchingArray0 extends StringMatchingArray
{
	public List<String> stringMatchingArray(String[] words)
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
}
