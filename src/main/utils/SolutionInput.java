package main.utils;

import java.lang.reflect.Method;

public final class SolutionInput
{
	public static final String INPUT_DELIMETER = "/";

	private final String rawInput;
	private final Object[] inputs;

	public SolutionInput(String rawInput, Solution solution)
	{
		this.rawInput = rawInput;

		String[] 						rawInputsSplit = rawInput.split(INPUT_DELIMETER);

		inputs = new Object[rawInputsSplit.length];

		Class<? extends Solution> 		solutionClass = solution.getClass();

		Method[] 						declaredMethods = solutionClass.getDeclaredMethods();

		// each problem should only have one method
		Method			declaredMethod = declaredMethods[0];

		Class<?>[] 		parameterTypes = declaredMethod.getParameterTypes();

		// use reflection to find the expected parameter inputs of each problem
		for (int i = 0; i < parameterTypes.length; i++)
		{
			Class<?> 	parameterType = parameterTypes[i];

			switch (parameterType.getCanonicalName())
			{
				case "int":
				{
					String 		currentRawInput = rawInputsSplit[i];

					inputs[i] = Integer.parseInt(currentRawInput);
					break;
				}

				case "int[]":
				{
					String 		currentRawInput = rawInputsSplit[i];

					inputs[i] = InputOutputParser.parseArrayIntString(currentRawInput);
					break;
				}
			}
		}
	}

	public Object getFirstInput()
	{
		return this.inputs[0];
	}

	public Object getInputAtIndex(int index)
	{
		return this.inputs[index];
	}

	public String getRawInput()
	{
		return rawInput;
	}
}
