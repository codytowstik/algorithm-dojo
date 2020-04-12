package main.easy;

import main.TestBase;
import main.easy.happy_number_202.HappyNumber0;
import main.easy.happy_number_202.HappyNumber1;
import org.junit.jupiter.api.Test;

public final class HappyNumberTest extends TestBase
{
	@Test
	public void testHappyNumber0()
	{
		testSolution(HappyNumber0.class);
	}

	@Test
	public void testHappyNumber1()
	{
		testSolution(HappyNumber1.class);
	}
}
