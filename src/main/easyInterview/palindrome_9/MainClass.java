package main.easyInterview.palindrome_9;

import main.utils.Solution;

import java.io.*;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

public class MainClass {

    private static final String INPUT_FILE_NAME = "input_9.properties";

    public static void main( String[] args )
    {
        Properties  expectedResults = Solution.loadExpectedResults( INPUT_FILE_NAME );

        // choose solution class here
        Solution    solution = new Solution0();

        for ( Map.Entry<Object, Object> entry: expectedResults.entrySet() )
        {
            String  input = (String) entry.getKey();

            int     numericInput = Integer.parseInt(input);

            long    start = System.nanoTime();

            // isPalindrome(int)
            Object  result = solution.execute(numericInput);

            long    totalTimeNano = System.nanoTime() - start;

            String  expectedResult = (String) entry.getValue();
            String  actualResult = String.valueOf(result);

            solution.saveResult(input, expectedResult, actualResult, totalTimeNano);
        }

        solution.validateResults();
    }
}
