package main;

import main.data_structures.ListNode;
import main.data_structures.ListNodeUtils;
import main.utils.*;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public abstract class TestBase
{
    protected static final String INPUT_FILE_NAME = "input.properties";

    private static final int ARRAY_LENGTH_LIMIT = 32;

    protected Map<String,String> expectedResults;
    protected SolutionResults solutionResults;

    /**
     * Assert two arrays are equal, order matters.
     *
     * If either array parameter is greater than ARRAY_LENGTH_LIMIT,
     * just compare the sizes. For large outputs, knowing the length difference is more useful
     * than a blob of array items.
     *
     * @param expected expected
     * @param actual actual
     */
    void assertEquals(int[] expected, int[] actual)
    {
        // if array exceeds our limit, only compare the lengths so we have nice output
        if ((expected.length > ARRAY_LENGTH_LIMIT) || (actual.length > ARRAY_LENGTH_LIMIT))
        {
            Assertions.assertEquals(expected.length, actual.length, "Array lengths differ.");
        }
        else
        {
            // convert to pretty string and then compare so error output is easy to read
            // .. this is a test! we don't care about performance as much
            String      prettyArr1String = prettyPrintArray(expected);
            String      prettyArr2String = prettyPrintArray(actual);

            Assertions.assertEquals(prettyArr1String, prettyArr2String);
        }
    }

    /**
     * Assert content equality for two `List<List<Integer>>` objects.
     *
     * The order doesn't matter for inner lists, nor inner list values.
     *
     * @param expected expected
     * @param actual actual
     */
    void assertEqualsIgnoreOrder(List<List<Integer>> expected, List<List<Integer>> actual)
    {
        Assertions.assertEquals(expected.size(), actual.size(), "Different number of results.");

        List<List<Integer>>     expectedSorted = Utils.deepSortListListInteger(expected);
        List<List<Integer>>     actualSorted = Utils.deepSortListListInteger(actual);

        Assertions.assertEquals(expectedSorted, actualSorted);
    }

    /**
     * Pretty print an integer array.
     *
     * ex:
     *  1, 2, 3, 4 (n=4) .. [1, 2, 3, 4]
     *
     * @param array the array
     * @return the array as a string
     */
    private String prettyPrintArray(int[] array)
    {
        StringBuilder  builder = new StringBuilder();

        builder.append("[");

        for (int i : array)
        {
            builder.append(i);

            builder.append(", ");
        }

        // remove the last comma/space

        builder.setLength(builder.length() - 2);

        builder.append("]");

        return builder.toString();
    }

    public static void testSolution(Class<? extends Solution> testClass)
    {
        Map<String, String>     expectedResults = DataLoader.loadExpectedResults(testClass, INPUT_FILE_NAME);
        SolutionResults         solutionResults = new SolutionResults();

        for (Map.Entry<String, String> entry : expectedResults.entrySet())
        {
            String                  rawInput = entry.getKey();
            SolutionInput           solutionInput = new SolutionInput(rawInput, testClass);

            String                  rawExpectedResult = entry.getValue();
            SolutionExpectedOutput  solutionExpectedOutput = new SolutionExpectedOutput(rawExpectedResult, testClass);

            Solution                testInstance;

            try
            {
                testInstance = testClass.getConstructor().newInstance();
            }
            catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException t)
            {
                throw new RuntimeException("Invalid class.");
            }

            SolutionResult
                solutionResult =
                    SolutionExecutor.executeAndTime(
                        testInstance,
                        solutionInput,
                        solutionExpectedOutput.getOutput());

            solutionResults.saveResult(solutionResult);
        }

        boolean     allResultsSuccessful = solutionResults.validateResults();

        assert allResultsSuccessful;
    }

    public static void assertEquals(ListNode head1, ListNode head2)
    {
        int firstIndexOfInequality = ListNodeUtils.getIndexOfFirstInequality(head1, head2);

        if (firstIndexOfInequality != -1)
        {
            String     printerResult1 = ListNodeUtils.buildRemainingNodesString(head1);
            String     printerResult2 = ListNodeUtils.buildRemainingNodesString(head2);

            Assertions.assertEquals(
                printerResult1,
                printerResult2,
                MessageFormat.format("Mismatched child nodes at index {0}", firstIndexOfInequality));
        }
    }
}
