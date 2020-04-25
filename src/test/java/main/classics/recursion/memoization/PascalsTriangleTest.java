package main.classics.recursion.memoization;

import main.TestBase;
import main.classics.recursion.relation.pascals_triangle_2.PascalsTriangle0;
import org.junit.jupiter.api.Test;

public class PascalsTriangleTest extends TestBase
{
	@Test
	public void testPascalsTriangle()
	{
		testSolution(PascalsTriangle0.class);
	}
}
