package main.utils;

public class SolutionExecutor
{
	public static SolutionResult executeAndTime(SolutionEx solutionEx, int input, Object expectedResult)
	{
		long 		start = System.nanoTime();

		Object 		result = solutionEx.execute(input);

		long 		end = System.nanoTime() - start;

		return new SolutionResult(input, expectedResult, result, end);
	}
}
