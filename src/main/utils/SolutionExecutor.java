package main.utils;

public class SolutionExecutor
{
	public static SolutionResult executeAndTime(SolutionEx solutionEx, int input, boolean expectedResult)
	{
		long 		start = System.nanoTime();

		boolean 	result = solutionEx.execute(input);

		long 		end = System.nanoTime() - start;

		return new SolutionResult(input, expectedResult, result, end);
	}
}
