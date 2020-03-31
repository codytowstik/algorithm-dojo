import main.utils.DataLoader;
import main.utils.MultiInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataLoaderTest extends TestBase
{
    @Test
    public void testIterationOrder()
    {
        String              testFileName = TestFileName.INT__INT_PROPERTIES.getFileName();

        Map<String,String>  inputOutput = DataLoader.loadExpectedResults(getClass(), testFileName);

        int expected = 0;

        for (String key : inputOutput.keySet())
        {
            Assertions.assertEquals(expected, Integer.parseInt(key) );

            expected++;
        }
    }

    @Test
    public void test_ArrayInt_Int_Inputs()
    {
        String                  testFileName = TestFileName.ARRAYINT_INT__ARRAYINT.getFileName();
        int                     expectedCount = 3;

        Map<String, String>     inputOutputs = DataLoader.loadExpectedResults(getClass(), testFileName);

        List<int[]>             expectedArrayIntInputs = new ArrayList<>(expectedCount);
        List<Integer>           expectedIntInputs = new ArrayList<>(expectedCount);

        expectedArrayIntInputs.add( new int[]{1,2,3});
        expectedIntInputs.add(5);

        expectedArrayIntInputs.add(new int[]{2, 7, 11, 15});
        expectedIntInputs.add(9);

        expectedArrayIntInputs.add( new int[]{3,2,4});
        expectedIntInputs.add(6);


        int propertyIndex = 0;

        for (Map.Entry<String, String> inputOutput : inputOutputs.entrySet())
        {
            Object      inputs = inputOutput.getKey();

            MultiInput  multiInput = new MultiInput(inputs);

            int[]       expectedArrayIntInput = expectedArrayIntInputs.get(propertyIndex);
            int[]       actualArrayIntInput = multiInput.parseArrayInt(0);

            int         expectedIntInput = expectedIntInputs.get(propertyIndex);
            int         actualIntInput = multiInput.parseInt(1);

            assertEquals(expectedArrayIntInput, actualArrayIntInput);
            Assertions.assertEquals(expectedIntInput, actualIntInput);

            propertyIndex++;
        }
    }

    @Test
    public void test_ArrayInt_Output()
    {

    }
}
