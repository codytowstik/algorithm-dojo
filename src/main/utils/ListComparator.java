package main.utils;

import java.util.Comparator;
import java.util.List;

/**
 * ListComparator.
 *
 * Comparator for sorting a collection of List objects e.g. `List<List<Integer>>`
 * @param <T>
 */
public class ListComparator<T extends Comparable<T>> implements Comparator<List<T>>
{
	@Override
	public int compare(List<T> o1, List<T> o2)
	{
		int 	lesserSize = Math.min(o1.size(), o2.size());

		// compare each item until they are unequal
		for (int i = 0; i < lesserSize; i++)
		{
			int 	comparisonResult = o1.get(i).compareTo(o2.get(i));

			if (comparisonResult != 0)
			{
				return comparisonResult;
			}
		}

		// otherwise return the shorter list
		return Integer.compare(o1.size(), o2.size());
	}
}
