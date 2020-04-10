package main.utils;

import java.lang.reflect.Method;

public final class SolutionExpectedOutput
{
	private final String rawOutput;
	private final Object output;

	public SolutionExpectedOutput(String rawOutput, Solution solution)
	{
		this.rawOutput = rawOutput;

		Class<? extends Solution> 		solutionClass = solution.getClass();

		Method[] 						declaredMethods = solutionClass.getDeclaredMethods();

		// each problem should only have one method
		Method							declaredMethod = declaredMethods[0];

		Class<?> 						returnType = declaredMethod.getReturnType();

		// use reflection to find the expected parameter inputs of each problem
		switch (returnType.getCanonicalName())
		{
			case "int":
			{
				output = Integer.parseInt(rawOutput);
				break;
			}

			case "int[]":
			{
				output = InputOutputParser.parseArrayInt(rawOutput);
				break;
			}

			case "java.util.List":
			{
				// TODO: assuming this is a list of list of Integers until we need something more robust
				output = InputOutputParser.parseListListInteger(rawOutput);

				break;
			}

			default:
			{
				throw new RuntimeException("Unsupported class for output.");
			}
		}
	}

	public Object getOutput()
	{
		return this.output;
	}

	public String getRawOutput()
	{
		return rawOutput;
	}
}
