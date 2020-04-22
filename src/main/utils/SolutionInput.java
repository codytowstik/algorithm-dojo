package main.utils;

import java.lang.reflect.Method;
import java.text.MessageFormat;

public final class SolutionInput
{
	public static final String INPUT_DELIMETER = "/";

	private final String rawInput;
	private final Object[] inputs;

	public SolutionInput(String rawInput, Class<? extends Solution> solution)
	{
		this.rawInput = rawInput;

		String[] 		rawInputsSplit = rawInput.split(INPUT_DELIMETER);

		inputs = new Object[rawInputsSplit.length];

		Method[] 		declaredMethods = solution.getDeclaredMethods();

		// each problem should only have one public method
		Method			declaredMethod = Utils.getFirstPublicMethod(declaredMethods);

		Class<?>[] 		parameterTypes = declaredMethod.getParameterTypes();

		// use reflection to find the expected parameter inputs of each problem
		for (int i = 0; i < parameterTypes.length; i++)
		{
			String 		currentRawInput = rawInputsSplit[i];

			Class<?> 	parameterType = parameterTypes[i];

			String 		canonicalName = parameterType.getCanonicalName();

			switch (canonicalName)
			{
				case "int":
				{
					inputs[i] = Integer.parseInt(currentRawInput);
					break;
				}

				case "int[]":
				{
					inputs[i] = InputOutputParser.parseArrayInt(currentRawInput);
					break;
				}

				case "char[]":
				{
					inputs[i] = InputOutputParser.parseArrayChar(currentRawInput);
					break;
				}

				case "String":
				{
					inputs[i] = currentRawInput;
					break;
				}

				case "java.lang.String[]":
				{
					inputs[i] = InputOutputParser.parseArrayString(currentRawInput);
					break;
				}
			}
		}

		if (inputs.length == 0)
		{
			throw new RuntimeException(MessageFormat.format("Failed to parse input: {0}", rawInput));
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
