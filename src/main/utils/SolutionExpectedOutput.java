package main.utils;

import java.lang.reflect.Method;
import java.text.MessageFormat;

public final class SolutionExpectedOutput
{
	private final String rawOutput;
	private final Object output;

	public SolutionExpectedOutput(String rawOutput, Class<? extends Solution> solution)
	{
		this.rawOutput = rawOutput;

		Method[] 						declaredMethods = solution.getDeclaredMethods();

		// each problem should only have one method
		Method							declaredMethod = declaredMethods[0];

		Class<?> 						returnType = declaredMethod.getReturnType();

		String 							returnTypeCanonicalName = returnType.getCanonicalName();

		// use reflection to find the expected parameter inputs of each problem
		switch (returnTypeCanonicalName)
		{
			case "boolean":
			{
				output = Boolean.parseBoolean(rawOutput);
				break;
			}

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
				throw new RuntimeException(MessageFormat.format("Unsupported class for output: {0}", returnTypeCanonicalName));
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
