package main.easy.reverse_integer_7;

import main.utils.*;

import java.util.Map;

public class ReverseIntegerRunner
{

    private static final String INPUT_FILE_NAME = "input.properties";

    private static final ReverseInteger TEST_CLASS = new ReverseInteger0();

    public static void main( String[] args )
    {
        Map<String,String>  expectedResults = DataLoader.loadExpectedResults( TEST_CLASS.getClass(), INPUT_FILE_NAME );
        SolutionResults     solutionResults = new SolutionResults();

        for ( Map.Entry<String, String> entry: expectedResults.entrySet() )
        {
            String      rawInput = entry.getKey();
            int         input = Integer.parseInt(rawInput);

            String      rawExpectedResult = entry.getValue();
            int         expectedResult = Integer.parseInt(rawExpectedResult);

            // int reverseInteger(int)
            SolutionResult solutionResult = SolutionExecutor.executeAndTime(TEST_CLASS, input, expectedResult);

            solutionResults.saveResult(solutionResult);
        }

        solutionResults.validateResults();
    }
}
