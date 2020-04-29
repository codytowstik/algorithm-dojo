package main.classics.recursion.memoization;

import main.TestBase;
import main.classics.recursion.memoization.climbing_stairs.*;
import org.junit.jupiter.api.Test;

public class ClimbingStairsTest extends TestBase
{
	@Test
	public void testClimbingStairs0()
	{
		testSolution(ClimbingStairs0.class);
	}

	@Test
	public void testClimbingStairs1()
	{
		testSolution(ClimbingStairs1.class);
	}

	@Test
	public void testClimbingStairsEx0()
	{
		testSolution(ClimbingStairsEx0.class);
	}

	@Test
	public void testClimbingStairsEx1()
	{
		testSolution(ClimbingStairsEx1.class);
	}

	@Test
	public void testClimbingStairsEx2()
	{
		testSolution(ClimbingStairsEx2.class);
	}

	@Test
	public void testClimbingStairsEx3()
	{
		testSolution(ClimbingStairsEx3.class);
	}

	@Test
	public void testClimbingStairsEx4()
	{
		testSolution(ClimbingStairsEx4.class);
	}
}
