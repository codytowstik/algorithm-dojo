package main.weekly.week_184;

import main.TestBase;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class QueriesOnPermutationTest extends TestBase
{
	@Test
	public void testQueriesOnPermutation0()
	{
		int[] 	inputArr1 = new int[]{3, 1, 2, 1};
		int 	m1 = 5;
		int[]	output1 = new int[]{2,1,2,1};

		int[] 	inputArr2 = new int[]{4, 1, 2, 2};
		int 	m2 = 4;
		int[] 	output2 = new int[]{3, 1, 2, 0};

		int[] 	inputArr3 = new int[]{7, 5, 5, 8, 3};
		int 	m3 = 8;
		int[] 	output3 = new int[]{6,5,0,7,5};

		boolean result1 = Arrays.equals(processQueries(inputArr1, m1), output1);
		boolean result2 = Arrays.equals(processQueries(inputArr2, m2), output2);
		boolean result3 = Arrays.equals(processQueries(inputArr3, m3), output3);

		assert result1;
		assert result2;
		assert result3;
	}

	public int[] processQueries(int[] queries, int m)
	{
		Map<Integer,Integer> 	valuesToIndex = new HashMap<>(m);

		// store current index of numbers in P in hash map
		for (int i = 1; i <= m; i++)
		{
			valuesToIndex.put(i, i-1);
		}

		// get the index of the value in the map
		// save the value
		// reset all the values in the map

		int[] 		result = new int[queries.length];

		for (int i = 0; i < queries.length; i++)
		{
			int 		currentValueToCheck = queries[i];

			Integer 	queryIndex = valuesToIndex.get(currentValueToCheck);

			result[i] = queryIndex;

			valuesToIndex.put(currentValueToCheck, 0);

			// any value in has map less than current index is incremented by 1, current value set to 0

			for (Map.Entry<Integer, Integer> entry : valuesToIndex.entrySet())
			{
				int		value = entry.getKey();
				int	 	index = entry.getValue();

				if (value != currentValueToCheck && index < queryIndex)
				{
					int 	newIndex = index + 1;

					valuesToIndex.put(value, newIndex);
				}
			}
		}

		return result;
	}
}
