import main.medium.threesum_15.ThreeSum;
import main.medium.threesum_15.ThreeSum0;
import main.utils.*;
import org.junit.jupiter.api.Test;

import java.util.Map;

public final class ThreeSumTest extends TestBase
{
    private static final String INPUT_FILE_NAME = "input.properties";

    @Test
    public void testThreeSum0()
    {
        final ThreeSum          testClass = new ThreeSum0();

        Map<String, String>     expectedResults = DataLoader.loadExpectedResults(testClass.getClass(), INPUT_FILE_NAME);
        SolutionResults         solutionResults = new SolutionResults();

        for (Map.Entry<String, String> entry : expectedResults.entrySet())
        {
            String      rawInput = entry.getKey();
            int         input = Integer.parseInt(rawInput);

            String      rawExpectedResult = entry.getValue();
            int         expectedResult = Integer.parseInt(rawExpectedResult);

            // List<List<Integer>> threeSum(int[] nums)
            SolutionResult  solutionResult = SolutionExecutor.executeAndTime(testClass, input, expectedResult);

            solutionResults.saveResult(solutionResult);
        }

        boolean allResultsSuccessful = solutionResults.validateResults();

        assert allResultsSuccessful;
    }
}
