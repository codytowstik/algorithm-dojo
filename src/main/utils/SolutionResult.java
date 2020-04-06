package main.utils;

import java.util.Objects;

public final class SolutionResult
{
	private final int input;
	private final boolean expectedResult;
	private final boolean actualResult;
	private final long executeTime;

	public SolutionResult(int input, boolean expectedResult, boolean actualResult, long executeTime)
	{
		this.input = input;
		this.expectedResult = expectedResult;
		this.actualResult = actualResult;
		this.executeTime = executeTime;
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
