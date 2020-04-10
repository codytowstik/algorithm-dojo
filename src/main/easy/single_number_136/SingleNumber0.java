package main.easy.single_number_136;

public class SingleNumber0 extends SingleNumber
{
	/**
	 * 1ms, 51%
	 * 43.4mb
	 *
	 * @param input
	 * @return
	 */
	public int singleNumber(int[] input)
	{
		int singleNumber = 0;

		for (int value : input)
		{
			singleNumber ^= value;
		}

		return singleNumber;
	}
}
