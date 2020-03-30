package main.easy.reverse_integer_7;

import main.utils.Solution;

import java.util.Map;
import java.util.Properties;

public class MainClass {

    private static final String INPUT_FILE_NAME = "input.properties";

    private static final Solution TEST_CLASS = new Solution2();

    public static void main( String[] args )
    {
        Properties  expectedResults = Solution.loadExpectedResults( MainClass.class, INPUT_FILE_NAME );

        for ( Map.Entry<Object, Object> entry: expectedResults.entrySet() )
        {
            String  input = (String) entry.getKey();

            int     numericInput = Integer.parseInt(input);

            long    start = System.nanoTime();

            // reverseInteger(int)
            Object  result = TEST_CLASS.execute(numericInput);

            long    totalTimeNano = System.nanoTime() - start;

            String  expectedResult = (String) entry.getValue();
            String  actualResult = String.valueOf(result);

            TEST_CLASS.saveResult(input, expectedResult, actualResult, totalTimeNano);
        }

        TEST_CLASS.validateResults();
    }
}
