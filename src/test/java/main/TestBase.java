package main;

import main.data_structures.ListNode;
import main.data_structures.ListNodeUtils;
import main.data_structures.TreeNode;
import main.data_structures.TreeNodeUtils;
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
    protected SolutionResultsValidator solutionResultsValidator;

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
        Map<String, String>             expectedResults = DataLoader.loadExpectedResults(testClass, INPUT_FILE_NAME);
        SolutionResultsValidator solutionResultsValidator = new SolutionResultsValidator();

        for (Map.Entry<String, String>  entry : expectedResults.entrySet())
        {
            String                      rawInput = entry.getKey();
            SolutionInput               solutionInput = new SolutionInput(rawInput, testClass);

            String                      rawExpectedResult = entry.getValue();
            SolutionExpectedOutput      solutionExpectedOutput = new SolutionExpectedOutput(rawExpectedResult, testClass);

            Solution                    testInstance;

            try
            {
                // we need to build a new instance because you can't statically define a different implementation
                // of solution implementations (e.g. ThreeSum0, ThreeSum1, etc)
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
                        solutionExpectedOutput);

            solutionResultsValidator.saveResult(solutionResult);
        }

        boolean     allResultsSuccessful = solutionResultsValidator.validateResults();

        assert allResultsSuccessful;
    }

    /**
     * Assert the head and subsequent children of two ListNodes are equal.
     *
     * @param head1
     * @param head2
     */
    public static void assertEquals(ListNode head1, ListNode head2)
    {
        System.out.println("Testing: ");
        ListNodeUtils.printRemainingNodes(head1);
        ListNodeUtils.printRemainingNodes(head2);
        System.out.println();

        int     firstIndexOfInequality = ListNodeUtils.getIndexOfFirstInequality(head1, head2);

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

    /**
     * Assert the head and subsequent children of two TreeNodes are equal.
     *
     * @param root1
     * @param root2
     */
    public static void assertEquals(TreeNode root1, TreeNode root2)
    {
        System.out.println("Testing: ");
        TreeNodeUtils.printRemainingNodes(root1);
        System.out.println("----");
        TreeNodeUtils.printRemainingNodes(root2);
        System.out.println();

        boolean         allEqual = TreeNodeUtils.compareTreeNodesDFS(root1, root2);

        Assertions.assertTrue(allEqual, "Unequal nodes in tree.");
    }
}
