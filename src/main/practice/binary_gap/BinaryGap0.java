package main.practice.binary_gap;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * Found on practice test.
 */
public final class BinaryGap0
{
	public static int calculateGap(int N)
	{
		// given positive integer N
		// return length of longest binary gab
		// return 0 if N doesn't contain a binary gap

		// N [1, MAX_INT]

		// 1041, 10000010001
		// returns 5

		// 32, 100000
		// returns 0, no gap

		// 'longestGap' = 0
		int longestGap = 0;
		// 'firstOne' = -1
		int firstOne;
		// 'secondOne' = -1
		int secondOne ;

		int[] binaryRep = new int[32];

		for (int i = 0; i < 32; i++)
		{
			int b = ((N >> i) & 1);
			binaryRep[i] = b;
		}

		print("binary: {0}", Arrays.toString(binaryRep));

		// find index of first 1 - save in 'firstOne'
		firstOne = findNextOneIndex(N, 0);

		// while 'firstOne != -1'
		while (firstOne != -1)
		{
			print("");
			print("firstOne: {0}", firstOne);
			// find index of second 1 - save in 'secondOne'
			secondOne = findNextOneIndex(N, firstOne + 1);
			print("secondOne: {0}", secondOne);
			// if 'secondOne' > 0
			if (secondOne > 0)
			{
				// 'currentGap' = 'secondOne' - 'firstOne'
				int currentGap = secondOne - firstOne - 1;

				print("Gap: {0}", currentGap);

				// if 'currentGap' > 'longestGap'
				if (currentGap > longestGap)
				{
					// 'longestGap' = 'currentGap' - 1 (index of 5 - index of 4 is gap of zero)
					// 'firstOne' = 'secondOne'
					// 'secondOne' = -1
					longestGap = currentGap;
					firstOne = secondOne;
					secondOne = -1;
				}
				else
				{
					// 'firstOne' = 'secondOne'
					// 'secondOne' = -1
					firstOne = secondOne;
					secondOne = -1;
				}
			}
			else
			{
				break;
			}
			// else
			// break (no more ones)
		}

		// return 'longestGap'

		return longestGap;
	}

	private static int findNextOneIndex(int number, int startIndex)
	{
		int index = startIndex;

		while ((number >> index) > 0)
		{
			int b = (number >> index) & 1;

			if (b == 1)
			{
				return index;
			}

			++index;
		}
		// for (int i = startIndex; i <= 8; i++)
		// {
		//     int b = ((number >> i) & 1);
		//
		//     if (b == 1)
		//     {
		//         return i;
		//     }
		// }

		return -1;
	}

	private static void print(String message)
	{
		print(message, null);
	}

	private static void print(String message, Object o1)
	{
		String messageFormatted;

		if (o1 != null && o1.getClass().isArray())
		{
			messageFormatted = MessageFormat.format(message, Arrays.toString((String[]) o1));
		}
		else
		{
			messageFormatted = MessageFormat.format(message, o1);
		}

		System.out.println(messageFormatted);
	}
}
