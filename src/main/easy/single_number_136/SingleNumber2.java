package main.easy.single_number_136;

import java.util.Arrays;

public class SingleNumber2 extends SingleNumber
{
	/**
	 * SingleNumber.
	 *
	 * Stream implementation.
	 *
	 * 4ms, 39.6%
	 * 43.3mb, 5.19%
	 *
	 * @param input
	 * @return
	 */
	public int singleNumber(int[] input)
	{
		int singleNumber =
			Arrays
				.stream(input)
				.reduce(0, (collector, value) -> collector ^= value);

		return singleNumber;
	}
}
