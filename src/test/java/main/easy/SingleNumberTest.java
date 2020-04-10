package main.easy;

import main.easy.single_number_136.SingleNumber;
import main.easy.single_number_136.SingleNumber0;
import main.easy.single_number_136.SingleNumber1;
import main.easy.single_number_136.SingleNumber2;
import main.utils.*;
import org.junit.jupiter.api.Test;

import java.util.Map;

public final class SingleNumberTest
{
	private static final String INPUT_FILE_NAME = "input.properties";
	
	@Test
	public void testSingleNumber0()
	{
		final SingleNumber		testClass = new SingleNumber0();

		Map<String, String> 	expectedResults = DataLoader.loadExpectedResults(testClass.getClass(), INPUT_FILE_NAME);
		SolutionResults 		solutionResults = new SolutionResults();
		
		for (Map.Entry<String, String> entry : expectedResults.entrySet())
        {
            String          rawInput = entry.getKey();
            SolutionInput   solutionInput = new SolutionInput(rawInput, testClass);

            String          rawExpectedResult = entry.getValue();
			int 			expectedResult = Integer.parseInt(rawExpectedResult);

            // int singleNumber(int[] input);
            SolutionResult  solutionResult = SolutionExecutor.executeAndTime(testClass, solutionInput, expectedResult);

            solutionResults.saveResult(solutionResult);
        }

        boolean     allResultsSuccessful = solutionResults.validateResults();

        assert allResultsSuccessful;
	}

	@Test
	public void testSingleNumber1()
	{
		final SingleNumber		testClass = new SingleNumber1();

		Map<String, String> 	expectedResults = DataLoader.loadExpectedResults(testClass.getClass(), INPUT_FILE_NAME);
		SolutionResults 		solutionResults = new SolutionResults();

		for (Map.Entry<String, String> entry : expectedResults.entrySet())
        {
            String          rawInput = entry.getKey();
            SolutionInput   solutionInput = new SolutionInput(rawInput, testClass);

            String          rawExpectedResult = entry.getValue();
			int 			expectedResult = Integer.parseInt(rawExpectedResult);

            // int singleNumber(int[] input);
            SolutionResult  solutionResult = SolutionExecutor.executeAndTime(testClass, solutionInput, expectedResult);

            solutionResults.saveResult(solutionResult);
        }

        boolean     allResultsSuccessful = solutionResults.validateResults();

        assert allResultsSuccessful;
	}

	@Test
	public void testSingleNumber2()
	{
		final SingleNumber		testClass = new SingleNumber2();

		Map<String, String> 	expectedResults = DataLoader.loadExpectedResults(testClass.getClass(), INPUT_FILE_NAME);
		SolutionResults 		solutionResults = new SolutionResults();

		for (Map.Entry<String, String> entry : expectedResults.entrySet())
        {
            String          rawInput = entry.getKey();
            SolutionInput   solutionInput = new SolutionInput(rawInput, testClass);

            String          rawExpectedResult = entry.getValue();
			int 			expectedResult = Integer.parseInt(rawExpectedResult);

            // int singleNumber(int[] input);
            SolutionResult  solutionResult = SolutionExecutor.executeAndTime(testClass, solutionInput, expectedResult);

            solutionResults.saveResult(solutionResult);
        }

        boolean     allResultsSuccessful = solutionResults.validateResults();

        assert allResultsSuccessful;
	}
}
