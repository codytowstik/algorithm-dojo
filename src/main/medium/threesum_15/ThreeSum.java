package main.medium.threesum_15;

import main.utils.MultiInput;
import main.utils.Solution;
import main.utils.Utils;

import java.util.Map;
import java.util.Properties;

public class ThreeSum
{

    private static final String INPUT_FILE_NAME = "input.properties";

    private static final Solution TEST_CLASS = new Solution2();

    public static void main( String[] args )
    {
        Properties  expectedResults = Solution.loadExpectedResults( ThreeSum.class, INPUT_FILE_NAME );

        for ( Map.Entry<Object, Object> entry: expectedResults.entrySet() )
        {
            MultiInput  multiInput = new MultiInput(entry.getKey());

            long    start = System.nanoTime();

            // List<List<Integer>> threeSum(int[] nums)
            Object  result = TEST_CLASS.execute(multiInput);

            long    totalTimeNano = System.nanoTime() - start;

            String  expectedResult = (String) entry.getValue();
            String  actualResult = Utils.parseListListInt(result);

            TEST_CLASS.saveResult(multiInput.originalInput, expectedResult, actualResult, totalTimeNano);
        }

        TEST_CLASS.validateResults();
    }
}
