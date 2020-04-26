package main.classics.recursion.memoization;

import main.TestBase;
import main.classics.recursion.memoization.fibonacci.*;
import org.junit.jupiter.api.Test;

public class FibonacciTest extends TestBase
{
	@Test
	public void testFibonacci0()
	{
		testSolution(Fibonacci0.class);
	}

	@Test
	public void testFibonacci1()
	{
		testSolution(Fibonacci1.class);
	}

	@Test
	public void testFibonacci2()
	{
		testSolution(Fibonacci2.class);
	}

	@Test
	public void testFibonacci3()
	{
		testSolution(Fibonacci3.class);
	}

	@Test
	public void testFibonacci4()
	{
		testSolution(Fibonacci4.class);
	}
}
