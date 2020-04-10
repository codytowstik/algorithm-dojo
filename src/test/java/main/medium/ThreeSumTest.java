package main.medium;

import main.TestBase;
import main.threesum_15.ThreeSum;
import main.threesum_15.ThreeSum0;
import main.utils.*;
import org.junit.jupiter.api.Test;

import java.util.Map;

public final class ThreeSumTest extends TestBase
{
    @Test
    public void testThreeSum0()
    {
        final ThreeSum          testInstance = new ThreeSum0();

        Map<String, String>     expectedResults = DataLoader.loadExpectedResults(testInstance.getClass(), INPUT_FILE_NAME);
        SolutionResults         solutionResults = new SolutionResults();

        for (Map.Entry<String, String> entry : expectedResults.entrySet())
        {
            String                  rawInput = entry.getKey();
            SolutionInput           solutionInput = new SolutionInput(rawInput, testInstance);

            String                  rawExpectedResult = entry.getValue();
            SolutionExpectedOutput  solutionExpectedOutput = new SolutionExpectedOutput(rawExpectedResult, testInstance);

            // List<List<Integer>> threeSum(int[] nums)
            SolutionResult
                solutionResult =
                    SolutionExecutor.executeAndTime(
                        testInstance,
                        solutionInput,
                        solutionExpectedOutput.getOutput());

            solutionResults.saveResult(solutionResult);
        }

        boolean allResultsSuccessful = solutionResults.validateResults();

        assert allResultsSuccessful;
    }
}
