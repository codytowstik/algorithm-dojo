package main.practice.smallest_number_not_in_array;

import java.util.HashSet;
import java.util.Set;

public class SmallestNumberNotInArrayEx0
{
	public static int getNumber(int[] numbers)
	{
		int N = numbers.length;
		Set<Integer> set = new HashSet<>();
		for (int a : numbers) {
			if (a > 0) {
				set.add(a);
			}
		}
		for (int i = 1; i <= N + 1; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}

		return 0;
	}
}
