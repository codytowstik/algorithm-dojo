package main;

import main.utils.DataLoader;
import main.utils.TestValsParseUtils;
import main.utils.MultiInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class DataLoaderTest extends TestBase
{
    @Test
    public void testIterationOrder()
    {
        String              testFileName = TestFileName.INT__INT_PROPERTIES.getFileName();

        Map<String,String>  inputOutput = DataLoader.loadExpectedResults(TestProblem.class, testFileName);

        int expected = 0;

        for (String key : inputOutput.keySet())
        {
            Assertions.assertEquals(expected, Integer.parseInt(key));

            expected++;
        }
    }

    /**
     * TwoSum
     * ThreeSum
     */
    @Test
    public void test_ArrayInt_Int_Inputs()
    {
        String                  testFileName = TestFileName.ARRAYINT_INT__ARRAYINT.getFileName();
        int                     expectedCount = 3;

        Map<String, String>     inputOutputs = DataLoader.loadExpectedResults(TestProblem.class, testFileName);

        List<int[]>             expectedArrayIntInputs = new ArrayList<>(expectedCount);
        List<Integer>           expectedIntInputs = new ArrayList<>(expectedCount);

        expectedArrayIntInputs.add( new int[]{1,2,3});
        expectedIntInputs.add(5);

        expectedArrayIntInputs.add(new int[]{2, 7, 11, 15});
        expectedIntInputs.add(9);

        expectedArrayIntInputs.add( new int[]{3,2,4});
        expectedIntInputs.add(6);


        int     propertyIndex = 0;

        for (String inputs : inputOutputs.keySet())
        {
            MultiInput  multiInput = new MultiInput(inputs);

            int[]       expectedArrayIntInput = expectedArrayIntInputs.get(propertyIndex);
            int[]       actualArrayIntInput = multiInput.parseArrayInt(0);

            int         expectedIntInput = expectedIntInputs.get(propertyIndex);
            int         actualIntInput = multiInput.parseInt(1);

            assertEquals(expectedArrayIntInput, actualArrayIntInput);
            Assertions.assertEquals(expectedIntInput, actualIntInput);

            propertyIndex++;
        }

        Assertions.assertEquals(expectedCount, propertyIndex, "Unexpected property count.");
    }

    /**
     * TwoSum
     */
    @Test
    public void test_ArrayInt_Output()
    {
        String                  testFileName = TestFileName.ARRAYINT_INT__ARRAYINT.getFileName();
        int                     expectedCount = 3;

        Map<String, String>     inputOutputs = DataLoader.loadExpectedResults(TestProblem.class, testFileName);

        List<int[]>             expectedOutputs = new ArrayList<>(expectedCount);

        expectedOutputs.add(new int[]{1,2});

        expectedOutputs.add(new int[]{0,1});

        expectedOutputs.add(new int[]{1,2});

        int     propertyIndex = 0;

        for (String output : inputOutputs.values())
        {
            int[]     expectedOutput = expectedOutputs.get(propertyIndex);
            int[]     actualOutput = TestValsParseUtils.parseArrayInt(output);

            assertEquals(expectedOutput, actualOutput);

            propertyIndex++;
        }

        Assertions.assertEquals(expectedCount, propertyIndex, "Unexpected property count.");
    }

    /**
     * ThreeSum
     */
    @Test
    public void test_ListListInt_Output()
    {
        String                      testFileName = TestFileName.ARRAYINT__LISTLISTINT.getFileName();
        int                         expectedCount = 5;

        Map<String, String>         inputOutputs = DataLoader.loadExpectedResults(TestProblem.class, testFileName);

        // build our Lists

        // 1
        List<List<Integer>> output1 = new ArrayList<>();

        output1.add(Arrays.asList(-1, -1, 2));

        // 2
        List<List<Integer>>         output2 = new ArrayList<>();

        output2.add(Arrays.asList(-1, 0, 1));
        output2.add(Arrays.asList(-1, -1, 2));

        // 3
        List<List<Integer>>         output3 = new ArrayList<>();

        output3.add(Arrays.asList(-1, 0, 1));
        output3.add(Arrays.asList(-2, 0, 2));

        // 4
        List<List<Integer>>         output4 = new ArrayList<>();

        output4.add(Arrays.asList(-4, 2, 2));
        output4.add(Arrays.asList(-4, 1, 3));
        output4.add(Arrays.asList(-4, 0, 4));
        output4.add(Arrays.asList(-4, -2, 6));
        output4.add(Arrays.asList(-2, 0, 2));
        output4.add(Arrays.asList(-2, -2, 4));

        // 5
        List<List<Integer>>         output5 = new ArrayList<>();

        output5.add(Arrays.asList(0, 0, 0));

        // collect our expected results

        List<List<List<Integer>>>   expectedOutputs = new ArrayList<>(expectedCount);

        expectedOutputs.add(output1);
        expectedOutputs.add(output2);
        expectedOutputs.add(output3);
        expectedOutputs.add(output4);
        expectedOutputs.add(output5);

        int propertyIndex = 0;

        for (String output : inputOutputs.values())
        {
            List<List<Integer>>     expectedOutput = expectedOutputs.get(propertyIndex);
            List<List<Integer>>     actualOutput = TestValsParseUtils.parseListListInteger(output);

            assertEqualsIgnoreOrder(expectedOutput, actualOutput);

            propertyIndex++;
        }

        Assertions.assertEquals(expectedCount, propertyIndex, "Unexpected property count.");
    }
}
