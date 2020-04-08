import main.easy.two_sum_1.TwoSum;
import main.easy.two_sum_1.TwoSum0;
import main.medium.threesum_15.ThreeSum;
import main.medium.threesum_15.ThreeSum0;
import main.utils.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class TwoSumTest extends TestBase
{
    private static final String INPUT_FILE_NAME = "input.properties";

    @Test
    public void testTwoSum0()
    {
        final TwoSum            testClass = new TwoSum0();

        Map<String, String>     expectedResults = DataLoader.loadExpectedResults(testClass.getClass(), INPUT_FILE_NAME);
        SolutionResults         solutionResults = new SolutionResults();

        for (Map.Entry<String, String> entry : expectedResults.entrySet())
        {
            String          rawInput = entry.getKey();
            SolutionInput   solutionInput = new SolutionInput(rawInput, testClass);

            String          rawExpectedResult = entry.getValue();
            int[]           expectedResult = DataLoader.valueOfArrayIntString(rawExpectedResult);

            int input = 0;
            // List<List<Integer>> threeSum(int[] nums)
            SolutionResult  solutionResult = SolutionExecutor.executeAndTime(testClass, input, expectedResult);

            solutionResults.saveResult(solutionResult);
        }

        boolean     allResultsSuccessful = solutionResults.validateResults();

        assert allResultsSuccessful;
    }
}
