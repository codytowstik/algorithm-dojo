package main.utils;

import java.util.Objects;

public final class SolutionResult
{
	private final String rawInput;
	private final Object expectedResult;
	private final Object actualResult;
	private final long executeTime;

	public SolutionResult(
		String 		rawInput,
		Object 		expectedResult,
		Object 		actualResult,
		long 		executeTime)
	{
		this.rawInput = rawInput;
		this.expectedResult = expectedResult;
		this.actualResult = actualResult;
		this.executeTime = executeTime;
	}

	public String getRawInput()
	{
		return rawInput;
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

		return rawInput == that.rawInput;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(rawInput);
	}
}
