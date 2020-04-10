package main.easy.single_number_136;

public class SingleNumber1 extends SingleNumber
{
	/**
	 * SingleNumber.
	 *
	 * Fori implementation.
	 *
	 * 1ms, 51%
	 *
	 * @param input
	 * @return
	 */
	public int singleNumber(int[] input)
	{
		int singleNumber = input[0];

		for (int i = 1; i < input.length; i++)
		{
			singleNumber ^= input[i];
		}

		return singleNumber;
	}
}
