package main.classics.recursion.relation.pascals_triangle_2;

import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle0 extends PascalsTriangle
{
	@Override
	public List<Integer> getRow(int rowIndex)
	{
		if (rowIndex < 0)
		{
			return new LinkedList<>();
		}
		else
		{
			List<Integer>	previousRow = getRow(rowIndex - 1);

			for (int prevColumn = 0; prevColumn < previousRow.size() - 1; prevColumn++)
			{
				int		value = previousRow.get(prevColumn) + previousRow.get(prevColumn + 1);

				previousRow.set(prevColumn, value);
			}

			previousRow.add(0, 1);

			return previousRow;
		}
	}
}
