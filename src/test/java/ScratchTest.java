import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public final class ScratchTest extends TestBase
{
	@Test
	public void testSingleNumber()
	{
		int[] input1 = {1,2,2};
		int expected1 = 1;

		int[] input2 = {3,3,1,2,2};
		int expected2 = 1;

		int[] input3 = {3,1,1,2,2};
		int expected3 = 3;

		int result1 = singleNumber(input1);
		int result2 = singleNumber(input2);
		int result3 = singleNumber(input3);

		Assertions.assertEquals(expected1, result1);
		Assertions.assertEquals(expected2, result2);
		Assertions.assertEquals(expected3, result3);
		System.out.println("Done.");
	}

	/**
	 * 1ms, 51%
	 * 43.4mb
	 *
	 * @param input
	 * @return
	 */
	private int singleNumber(int[] input)
	{
		int singleNumber = 0;

		for (int value : input)
		{
			singleNumber ^= value;
		}

		return singleNumber;
	}

	/**
	 * 1ms, 51%
	 *
	 * @param input
	 * @return
	 */
	private int singleNumberFori(int[] input)
	{
		int singleNumber = input[0];

		for (int i = 1; i < input.length; i++)
		{
			singleNumber ^= input[i];
		}

		return singleNumber;
	}

	/**
	 * 4ms, 39.6%
	 * 43.3mb, 5.19%
	 * @param input
	 * @return
	 */
	private int singleNumberStream(int[] input)
	{
		int singleNumber =
				Arrays
					.stream(input)
					.reduce(0, (collector, value) -> collector ^= value);

		return singleNumber;
	}
}
