package main.utils;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.MessageFormat;

public final class SolutionExpectedOutput
{
	private final String rawOutput;
	private final Object output;

	boolean isVoid = false;

	public SolutionExpectedOutput(String rawOutput, Class<? extends Solution> solution)
	{
		this.rawOutput = rawOutput;

		Method[] 			declaredMethods = solution.getDeclaredMethods();

		// each problem should only have one method
		Method				declaredMethod = Utils.getFirstPublicMethod(declaredMethods);

		Class<?> 			returnType = declaredMethod.getReturnType();

		String 				returnTypeCanonicalName = returnType.getCanonicalName();

		// use reflection to find the expected parameter inputs of each problem
		switch (returnTypeCanonicalName)
		{
			// void return type means output is the same type as the input (in-place)
			case "void":
			{
				isVoid = true;

				// get input of first parameter, assuming the first parameter is the correct type for in-place
				// TODO: not assume the first param is the right type
				Class<?>[] 		parameterTypes = declaredMethod.getParameterTypes();

				Class<?> 		parameterType = parameterTypes[0];

				String 			canonicalName = parameterType.getCanonicalName();

				switch (canonicalName)
				{
					case "char[]":
					{
						output = TestValsParseUtils.parseArrayChar(rawOutput);
						break;
					}

					default:
					{
						throw new RuntimeException(MessageFormat.format("Unsupported class for in-place output: {0}", returnTypeCanonicalName));
					}
				}

				break;
			}

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
				output = TestValsParseUtils.parseArrayInt(rawOutput);
				break;
			}

			case "double":
			{
				output = Double.parseDouble(rawOutput);
				break;
			}

			case "java.util.List":
			{
				Type 					genericReturnType = declaredMethod.getGenericReturnType();

				ParameterizedType		listGenericType = (ParameterizedType) genericReturnType;

				Type					genericActualType = listGenericType.getActualTypeArguments()[0];

				// we are looking for Objects because lists don't hold primitives
				switch (genericActualType.getTypeName())
				{
					case "java.lang.String":
					{
						output = TestValsParseUtils.parseListString(rawOutput);
						break;
					}

					case "java.lang.Integer":
					{
						output = TestValsParseUtils.parseListInteger(rawOutput);
						break;
					}

					case "java.util.List<java.lang.Integer>":
					{
						output = TestValsParseUtils.parseListListInteger(rawOutput);
						break;
					}

					case "java.lang.Double":
					{
						output = TestValsParseUtils.parseListDouble(rawOutput);
						break;
					}

					default:
					{
						throw new RuntimeException(MessageFormat.format("Unsupported List generic type: {0}", genericActualType.getTypeName()));
					}
				}

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

	public boolean isVoid()
	{
		return isVoid;
	}
}
