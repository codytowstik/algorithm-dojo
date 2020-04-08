package main.utils;

import java.lang.reflect.Method;

public final class SolutionInput
{
	public static final String INPUT_DELIMETER = "/";

	private final Object[] inputs;

	public SolutionInput(String rawInput, SolutionEx solution)
	{
		String[] 						rawInputsSplit = rawInput.split(INPUT_DELIMETER);

		inputs = new Object[rawInputsSplit.length];

		Class<? extends SolutionEx> 	solutionClass = solution.getClass();

		Method[] 						declaredMethods = solutionClass.getDeclaredMethods();

		for (Method declaredMethod : declaredMethods)
		{
			String 		methodName = declaredMethod.getName();

			if (!methodName.equals("execute"))
			{
				Class<?>[] 		parameterTypes = declaredMethod.getParameterTypes();

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

							inputs[i] = DataLoader.valueOfArrayIntString(currentRawInput);
							break;
						}
					}
				}
			}
		}
	}

	enum ParamaterType
	{
		INT,
		ARRAY_INT;

		ParamaterType(){}

		static ParamaterType valueOf(Class<?> parameterType)
		{
			switch (parameterType.getName())
			{
				case "int": return INT;

				case "int[]": return ARRAY_INT;
			}

			return null;
		}
	}
}
