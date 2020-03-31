import main.utils.DataLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Properties;

public final class DataLoaderTest extends TestBase
{
    @Test
    public void testIterationOrder()
    {
        Properties inputOutput = DataLoader.loadExpectedResults(getClass(), SIMPLE_PROPERTIES);

        int expected = 0;

        for (Object key : inputOutput.keySet())
        {
            String keyString = (String) key;

            Assertions.assertEquals(expected, Integer.parseInt(keyString) );

            expected++;
        }
    }
}
