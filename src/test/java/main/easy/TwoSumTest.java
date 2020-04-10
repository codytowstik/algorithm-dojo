package main.easy;

import main.TestBase;
import main.easy.two_sum_1.TwoSum;
import main.easy.two_sum_1.TwoSum0;
import main.easy.two_sum_1.TwoSum3;
import main.utils.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

public final class TwoSumTest extends TestBase
{
    private static final String INPUT_FILE_NAME = "input.properties";

    @Disabled
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
            int[]           expectedResult = InputOutputParser.parseArrayInt(rawExpectedResult);

            // int[] twoSum(int[] nums, int target)
            SolutionResult  solutionResult = SolutionExecutor.executeAndTime(testClass, solutionInput, expectedResult);

            solutionResults.saveResult(solutionResult);
        }

        boolean     allResultsSuccessful = solutionResults.validateResults();

        assert allResultsSuccessful;
    }

    @Test
    public void testTwoSum3()
    {
        final TwoSum            testClass = new TwoSum3();

        Map<String, String>     expectedResults = DataLoader.loadExpectedResults(testClass.getClass(), INPUT_FILE_NAME);
        SolutionResults         solutionResults = new SolutionResults();

        for (Map.Entry<String, String> entry : expectedResults.entrySet())
        {
            String          rawInput = entry.getKey();
            SolutionInput   solutionInput = new SolutionInput(rawInput, testClass);

            String          rawExpectedResult = entry.getValue();
            int[]           expectedResult = InputOutputParser.parseArrayInt(rawExpectedResult);

            // int[] twoSum(int[] nums, int target)
            SolutionResult  solutionResult = SolutionExecutor.executeAndTime(testClass, solutionInput, expectedResult);

            solutionResults.saveResult(solutionResult);
        }

        boolean     allResultsSuccessful = solutionResults.validateResults();

        assert allResultsSuccessful;
    }
}
