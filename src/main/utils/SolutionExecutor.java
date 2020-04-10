package main.utils;

public class SolutionExecutor
{
	public static SolutionResult executeAndTime(
		Solution 		solution,
		SolutionInput 	input,
		Object 			expectedResult)
	{
		long 		start = System.nanoTime();

		Object 		result = solution.execute(input);

		long 		end = System.nanoTime() - start;

		return new SolutionResult(input.getRawInput(), expectedResult, result, end);
	}
}
