package main.easy;

import main.TestBase;
import main.easy.palindrome_9.Palindrome0;
import main.easy.palindrome_9.Palindrome1;
import org.junit.jupiter.api.Test;

public final class PalindromeTest extends TestBase
{
	@Test
	public void testPalindrome0()
	{
		testSolution(Palindrome0.class);
	}

	@Test
	public void testPalindrome1()
	{
		testSolution(Palindrome1.class);
	}
}
