import main.utils.DataLoader;

import java.util.Map;
import java.util.Properties;

public final class DataLoaderTest extends TestBase
{

    @Test
    public void testIterationOrder()
    {
        Properties inputOutput = DataLoader.loadExpectedResults(getClass(), SIMPLE_PROPERTIES);

        int expected = 0;

        for (Map.Entry<Object, Object> entry : inputOutput.entrySet())
        {

        }
    }
}
