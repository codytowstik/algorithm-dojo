package main.easy.palindrome_9;

import main.utils.DataLoader;

import java.util.Map;

public class MainClass {

    private static final String INPUT_FILE_NAME = "input.properties";

    private static final Palindrome TEST_CLASS = new Palindrome0();

    public static void main( String[] args )
    {
        Map<String,String>  expectedResults = DataLoader.loadExpectedResults( MainClass.class, INPUT_FILE_NAME );

        for ( Map.Entry<String, String> entry: expectedResults.entrySet() )
        {
            String      input = entry.getKey();

            int         numericInput = Integer.parseInt(input);

            long        start = System.nanoTime();

            // isPalindrome(int)
            boolean     result = TEST_CLASS.execute(numericInput);

            long        totalTimeNano = System.nanoTime() - start;

            String      expectedResult = entry.getValue();
            String      actualResult = String.valueOf(result);

            TEST_CLASS.saveResult(input, expectedResult, actualResult, totalTimeNano);
        }

        TEST_CLASS.validateResults();
    }
}
