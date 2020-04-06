package main.utils;

import java.util.LinkedHashSet;
import java.util.Set;

public class SolutionResults
{
	private static final int COLUMN_WIDTH = 64;

	private final Set<SolutionResult> results = new LinkedHashSet<>();

	public void saveResult(int input, boolean expectedResult, boolean actualResult, long executeTime)
	{
		results.add(new SolutionResult(input, expectedResult, actualResult, executeTime));
	}

	public void saveResult(SolutionResult solutionResult)
	{
		results.add(solutionResult);
	}

	/**
	 * Validate the results of execution on each input, and output the results to console .. prepended
	 * with 'FAILED!!` or `SUCCESS!` .. in column format.
	 */
	public void validateResults()
	{
		//
	}
}
