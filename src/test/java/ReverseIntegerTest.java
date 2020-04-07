import main.easy.reverse_integer_7.ReverseInteger;
import main.easy.reverse_integer_7.ReverseInteger0;
import main.utils.DataLoader;
import main.utils.SolutionExecutor;
import main.utils.SolutionResult;
import main.utils.SolutionResults;
import org.junit.jupiter.api.Test;

import java.util.Map;

public final class ReverseIntegerTest extends TestBase
{
	private static final String INPUT_FILE_NAME = "input.properties";

	@Test
	public void testReverseInteger0()
	{
		final ReverseInteger 	testClass = new ReverseInteger0();

		Map<String, String> 	expectedResults = DataLoader.loadExpectedResults(testClass.getClass(), INPUT_FILE_NAME);
		SolutionResults 		solutionResults = new SolutionResults();

		for (Map.Entry<String, String> entry : expectedResults.entrySet())
		{
			String 		rawInput = entry.getKey();
			int 		input = Integer.parseInt(rawInput);

			String 		rawExpectedResult = entry.getValue();
			int 		expectedResult = Integer.parseInt(rawExpectedResult);

			// boolean isPalindrome(int)
			SolutionResult solutionResult = SolutionExecutor.executeAndTime(testClass, input, expectedResult);

			solutionResults.saveResult(solutionResult);
		}

		boolean allResultsSuccessful = solutionResults.validateResults();

		assert allResultsSuccessful;
	}
}
