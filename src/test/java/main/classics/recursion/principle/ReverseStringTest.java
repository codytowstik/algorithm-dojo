package main.classics.recursion.principle;

import main.TestBase;
import main.classics.recursion.principle.reverse_string.ReverseString0;
import main.classics.recursion.principle.reverse_string.ReverseString1;
import org.junit.jupiter.api.Test;

public class ReverseStringTest extends TestBase
{
	@Test
	public void testReverseString0()
	{
		testSolution(ReverseString0.class);
	}

	@Test
	public void testReverseString1()
	{
		testSolution(ReverseString1.class);
	}
}
