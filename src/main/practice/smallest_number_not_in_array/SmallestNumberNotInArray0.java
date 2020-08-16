package main.practice.smallest_number_not_in_array;

import java.util.HashSet;
import java.util.Set;

public class SmallestNumberNotInArray0
{
	public static int getNumber(int[] numbers)
	{
		// given array of N integers
		// return smallest positive integer (greater than 0) that does not occur in A

		// n [1,100000]
		// element of A is integer [-1000000,1000000]

		// 'givenNumbers' set
		Set<Integer> givenNumbers = new HashSet<>();

		// for each integer in A
		for (int i = 0; i < numbers.length; i++)
		{
			//   if value is positive, save it in 'givenNumbers'
			if (numbers[i] > 0)
			{
				givenNumbers.add(numbers[i]);
			}
		}

		// fori (1, 100000)
		for (int value = 1; value < 100000; value++)
		{
			//  if index not in 'givenNumbers', return index
			if (!givenNumbers.contains(value))
			{
				return value;
			}
		}

		return 100000;
	}
}
