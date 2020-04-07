import main.easy.palindrome_9.Palindrome;
import main.easy.palindrome_9.Palindrome0;
import main.utils.DataLoader;
import main.utils.SolutionExecutor;
import main.utils.SolutionResult;
import main.utils.SolutionResults;
import org.junit.jupiter.api.Test;

import java.util.Map;

public final class PalindromeTest extends TestBase
{
	private static final String INPUT_FILE_NAME = "input.properties";

	@Test
	public void testPalindrome0()
	{
		final Palindrome 		testClass = new Palindrome0();

		Map<String, String> 	expectedResults = DataLoader.loadExpectedResults(Palindrome.class, INPUT_FILE_NAME);
		SolutionResults 		solutionResults = new SolutionResults();

		for (Map.Entry<String, String> entry : expectedResults.entrySet())
		{
			String 		rawInput = entry.getKey();
			int 		input = Integer.parseInt(rawInput);

			String 		rawExpectedResult = entry.getValue();
			boolean 	expectedResult = Boolean.parseBoolean(rawExpectedResult);

			// isPalindrome(int)
			SolutionResult 		solutionResult = SolutionExecutor.executeAndTime(testClass, input, expectedResult);

			solutionResults.saveResult(solutionResult);
		}

		boolean allResultsSuccessful = solutionResults.validateResults();

		assert allResultsSuccessful;
	}
}
