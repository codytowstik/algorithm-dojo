package main.utils;

import main.easyInterview.reverse_integer_7.MainClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

public abstract class Solution
{
    private static final int COLUMN_WIDTH = 16;

    private final Set<Result> results = new LinkedHashSet<>();

    public abstract Object execute(Object input);

    public static Properties loadExpectedResults( String propertiesFileName )
    {
        Properties expectedResults = new Properties();

        try
        {
            URL             url = MainClass.class.getResource(propertiesFileName);
            File            inputFile = new File(url.getPath());
            FileInputStream fileInputStream = new FileInputStream(inputFile);

            expectedResults.load(fileInputStream);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return expectedResults;
    }

    public void saveResult(String input, String expectedResult, String actualResult, long executeTime)
    {
        results.add(new Result(input, expectedResult, actualResult, executeTime));
    }

    /**
     * Validate the results of execution on each input, and output the results to console .. prepended
     * with 'FAILED!!` or `SUCCESS!` .. in column format.
     */
    public void validateResults()
    {

        for (Result result : results)
        {
            String expectedResult = result.expectedResult;
            String actualResult = result.actualResult;

            boolean success = expectedResult.equals(actualResult);

            StringBuilder resultBuilder = new StringBuilder();

            if (success)
            {
                resultBuilder.append("SUCCESS!  ");
            } else
            {
                resultBuilder.append("FAILED!!  ");
            }


            resultBuilder.append(Result.normalizeResultStringToColumnWidth(result.input));
            resultBuilder.append(Result.normalizeResultStringToColumnWidth(expectedResult));
            resultBuilder.append(Result.normalizeResultStringToColumnWidth(actualResult));
            resultBuilder.append(Result.normalizeResultStringToColumnWidth(result.executeTime));

            System.out.println(resultBuilder.toString());
            System.out.println();
        }
    }

    static class Result
    {
        private String input;
        private String expectedResult;
        private String actualResult;
        private String executeTime;

        Result(String input, String expectedResult, String actualResult, long executeTime)
        {
            this.input = input;
            this.expectedResult = expectedResult;
            this.actualResult = actualResult;
            this.executeTime = String.valueOf(executeTime);
        }

        /**
         * Normalize all strings to COLUMN_WIDTH length, truncating strings that are longer and adding extra
         * spaces to strings that are shorter.
         *
         * @param original the element
         * @return the normalized string
         */
        public static String normalizeResultStringToColumnWidth(String original)
        {
            int lengthLimit = Math.min(original.length(), COLUMN_WIDTH);

            String lengthLimitBound = original.substring(0, lengthLimit);

            // truncate strings that are too long
            StringBuilder normalizedBuilder = new StringBuilder(lengthLimitBound);

            int originalLength = original.length();

            int requiredBufferSize = Math.max(0, COLUMN_WIDTH - originalLength);

            // add any space buffering needed to meet our COLUMN_WIDTH
            normalizedBuilder.append(" ".repeat(requiredBufferSize));

            return normalizedBuilder.toString();
        }
    }
}
