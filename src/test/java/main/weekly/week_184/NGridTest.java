package main.weekly.week_184;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class NGridTest
{
	@Disabled
	@Test
	public void testNGrid()
	{
		int input1 = 2;
		int output1 = 54;

		int input2 = 2;
		int output2 = 54;

		int input3 = 2;
		int output3 = 54;

		int input4 = 2;
		int output4 = 54;

		int input5 = 2;
		int output5 = 54;


		int result1 = numOfWays(input1);
		int result2 = numOfWays(input2);
		int result3 = numOfWays(input3);
		int result4 = numOfWays(input4);
		int result5 = numOfWays(input5);

		assert result1 == output1;
		assert result2 == output2;
		assert result3 == output3;
		assert result4 == output4;
		assert result5 == output5;
	}

	int numOfWays(int n)
	{
		int		divider = (int) Math.pow(10, 9) + 7;

		return 0;
	}
}
