package main.utils;

import java.util.Objects;

public final class SolutionResult
{
	private final int input;
	private final Object expectedResult;
	private final Object actualResult;
	private final long executeTime;

	public SolutionResult(int input, Object expectedResult, Object actualResult, long executeTime)
	{
		this.input = input;
		this.expectedResult = expectedResult;
		this.actualResult = actualResult;
		this.executeTime = executeTime;
	}

	public int getInput()
	{
		return input;
	}

	public Object getExpectedResult()
	{
		return expectedResult;
	}

	public Object getActualResult()
	{
		return actualResult;
	}

	public long getExecuteTime()
	{
		return executeTime;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}

		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		SolutionResult 	that = (SolutionResult) o;

		return input == that.input;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(input);
	}
}
