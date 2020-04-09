package main.utils;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SolutionResults
{
	private static final int COLUMN_WIDTH = 64;

	private final Set<SolutionResult> results = new LinkedHashSet<>();
	private final Map<SolutionResult,Boolean> resultToSuccess = new LinkedHashMap<>();

	public void saveResult(SolutionResult solutionResult)
	{
		results.add(solutionResult);
	}

	/**
	 * Validate the results of execution on each input, and output the results to console .. prepended
	 * with 'FAILED!!` or `SUCCESS!` .. in column format.
	 */
	public boolean validateResults()
	{
		boolean			allResultsSuccess = true;
		long			averageExecuteTime = 0;

		for (SolutionResult result : results)
		{
			Object		expectedResult = result.getExpectedResult();
			Object		actualResult = result.getActualResult();
			long		executeTime = result.getExecuteTime();

			boolean 	thisResultSuccess = validateResult(expectedResult, actualResult);

			allResultsSuccess &= thisResultSuccess;

			trackResult(thisResultSuccess, result);

			// track total execution time so we can compute average
			averageExecuteTime += executeTime;
		}

		// calculate average execute time
		averageExecuteTime = averageExecuteTime / results.size();

		printResults(averageExecuteTime);

		return allResultsSuccess;
	}

	private boolean validateResult(Object expectedResult, Object actualResult)
	{
		return ResultValidator.isEqualsIgnoreOrder(expectedResult, actualResult);
	}

	private void trackResult(boolean success, SolutionResult solutionResult)
	{
		resultToSuccess.put(solutionResult, success);
	}

	private void printResults(long averageExecuteTime)
	{
		for (Map.Entry<SolutionResult, Boolean> entry : resultToSuccess.entrySet())
		{
			StringBuilder resultBuilder = new StringBuilder();

			// value should never be null, don't handle *if* it is so it's obvious if its wrong
			boolean			success = entry.getValue();

			if (success)
			{
				resultBuilder.append("SUCCESS!  ");
			}
			else
			{
				resultBuilder.append("FAILED!!  ");
			}

			// keep these variables here for easy debugging
			SolutionResult 		solutionResult = entry.getKey();

			String		input = solutionResult.getRawInput();
			Object		expectedResult = solutionResult.getExpectedResult();
			Object		actualResult = solutionResult.getActualResult();
			long		executeTime = solutionResult.getExecuteTime();

			String		expectedResultString = String.valueOf(expectedResult);
			String		actualResultString = String.valueOf(actualResult);
			String		executeTimeString = String.valueOf(executeTime);


			resultBuilder.append(normalizeResultStringToColumnWidth(input));
			resultBuilder.append(normalizeResultStringToColumnWidth(expectedResultString));
			resultBuilder.append(normalizeResultStringToColumnWidth(actualResultString));
			resultBuilder.append(normalizeResultStringToColumnWidth(executeTimeString));

			System.out.println(resultBuilder.toString());
			System.out.println();
		}

		System.out.println();
		System.out.println("Average execute Time: " + averageExecuteTime);
	}

	/**
	 * Normalize all strings to COLUMN_WIDTH length, truncating strings that are longer and adding extra
	 * spaces to strings that are shorter.
	 *
	 * @param original the element
	 * @return the normalized string
	 */
	public static String normalizeResultStringToColumnWidth(String original)
	{
		int 	lengthLimit = Math.min(original.length(), COLUMN_WIDTH);

		String 	lengthLimitBound = original.substring(0, lengthLimit);

		// truncate strings that are too long
		StringBuilder 	normalizedBuilder = new StringBuilder(lengthLimitBound);

		int 	originalLength = original.length();

		int 	requiredBufferSize = Math.max(0, COLUMN_WIDTH - originalLength);

		// add any space buffering needed to meet our COLUMN_WIDTH
		normalizedBuilder.append(" ".repeat(requiredBufferSize));

		return normalizedBuilder.toString();
	}
}
