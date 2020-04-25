package main.utils;

public class SolutionExecutor
{
	public static SolutionResult executeAndTime(
		Solution 					solution,
		SolutionInput 				input,
		SolutionExpectedOutput 		expectedResult)
	{
		long 		start = System.nanoTime();

		Object 		result = solution.execute(input);

		long 		end = System.nanoTime() - start;

		// if result is null, then the result is in-place so the 'result' should be input.getInputAtIndex(0)
		// TODO: we shouldn't assume the result is the first input, but so good so far
		if (expectedResult.isVoid())
		{
			result = input.getInputAtIndex(0);
		}

		return new SolutionResult(input.getRawInput(), expectedResult.getOutput(), result, end);
	}
}
