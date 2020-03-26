package main.easyInterview.palindrome_9;

import main.utils.Solution;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

public class MainClass {

    private static final String INPUT_FILE_NAME = "input_9.properties";

    private static final Solution TEST_CLASS = new Solution0();

    public static void main( String[] args )
    {
        Properties  expectedResults = Solution.loadExpectedResults( INPUT_FILE_NAME );

        for ( Map.Entry<Object, Object> entry: expectedResults.entrySet() )
        {
            String  input = (String) entry.getKey();

            int     numericInput = Integer.parseInt(input);

            long    start = System.nanoTime();

            // isPalindrome(int)
            Object  result = TEST_CLASS.execute(numericInput);

            long    totalTimeNano = System.nanoTime() - start;

            String  expectedResult = (String) entry.getValue();
            String  actualResult = String.valueOf(result);

            TEST_CLASS.saveResult(input, expectedResult, actualResult, totalTimeNano);
        }

        TEST_CLASS.validateResults();
    }
}
