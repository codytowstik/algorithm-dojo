package main.utils;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

public final class ResultValidator
{
	public static boolean isEqualsIgnoreOrder(Object o1, Object o2)
	{
		String 		canonicalName = o1.getClass().getCanonicalName();

		boolean		equal;

		switch (canonicalName)
		{
			case "int[]":
			{
				equal = Utils.isEqualsIgnoreOrder((int[]) o1, (int[]) o2);

				break;
			}

			case "boolean":
			case "java.lang.Boolean":
			case "java.lang.Integer":
			case "String":
			case "int":
			{
				equal = o1.equals(o2);

				break;
			}

			case "java.util.ArrayList":
			case "java.util.Arrays.ArrayList":
			{
				List<?>		list1 = (List<?>) o1;
				List<?>		list2 = (List<?>) o2;

				if (list1.size() != list2.size())
				{
					equal = false;
					break;
				}
				// if both are empty, they are equal
				else if (list1.size() == 0)
				{
					equal = true;
					break;
				}

				// check the sub-type of the list, if it is a List sub element, we need to use our special impl

				if (list1.get(0) instanceof List)
				{
					// TODO: assuming this is a list of list of Integers until we need something more robust

					List<List<Integer>> 	listList1 = (List<List<Integer>>) list1;
					List<List<Integer>> 	listList2 = (List<List<Integer>>) list2;

					equal = Utils.isEqualsIgnoreOrder(listList1, listList2);
				}
				else
				{
					// TODO: assuming this is a list of Integers until we need something more robust

					List<Integer> 	listInteger1 = (List<Integer>) list1;
					List<Integer> 	listInteger2 = (List<Integer>) list2;

					Collections.sort(listInteger1);
					Collections.sort(listInteger2);

					equal = listInteger1.equals(listInteger2);
				}

				break;
			}

			default:
			{
				throw new RuntimeException(MessageFormat.format("Unsupported class for comparing equality: {0}", canonicalName));
			}
		}

		return equal;
	}
}
