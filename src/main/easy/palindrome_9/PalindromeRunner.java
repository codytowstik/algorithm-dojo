package main.easy.palindrome_9;

import main.utils.*;

import java.util.Map;

public class PalindromeRunner
{

    private static final String INPUT_FILE_NAME = "input.properties";

    private static final Palindrome TEST_CLASS = new Palindrome0();

    public static void main( String[] args )
    {
        Map<String,String>  expectedResults = DataLoader.loadExpectedResults( Palindrome.class, INPUT_FILE_NAME );
        SolutionResults     solutionResults = new SolutionResults();

        for ( Map.Entry<String, String> entry: expectedResults.entrySet() )
        {
            String          rawInput = entry.getKey();
            SolutionInput   solutionInput = new SolutionInput(rawInput, Palindrome0.class);

            String          rawExpectedResult = entry.getValue();
            boolean         expectedResult = Boolean.parseBoolean(rawExpectedResult);

            // boolean isPalindrome(int)
            SolutionResult  solutionResult = SolutionExecutor.executeAndTime(TEST_CLASS, solutionInput, expectedResult);

            solutionResults.saveResult(solutionResult);
        }

       solutionResults.validateResults();
    }
}
