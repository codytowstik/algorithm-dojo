package main.medium;

import main.TestBase;
import main.threesum_15.ThreeSum;
import main.threesum_15.ThreeSum0;
import main.utils.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public final class ThreeSumTest extends TestBase
{
    Map<String, String> expectedResults;
    SolutionResults solutionResults;

    @BeforeEach
    void beforeEach()
    {
        expectedResults = DataLoader.loadExpectedResults(ThreeSum.class, INPUT_FILE_NAME);
        solutionResults = new SolutionResults();
    }

    @Test
    public void testThreeSum0()
    {
        final ThreeSum          testInstance = new ThreeSum0();

        testSolution(expectedResults, solutionResults, testInstance);
    }
}
