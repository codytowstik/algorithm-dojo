package main.easy;

import main.TestBase;
import main.easy.two_sum_1.TwoSum0;
import main.easy.two_sum_1.TwoSum3;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * int[] twoSum(int[] nums, int target)
 */
public final class TwoSumTest extends TestBase
{
    @Disabled
    @Test
    public void testTwoSum0()
    {
       testSolution(TwoSum0.class);
    }

    @Test
    public void testTwoSum3()
    {
        testSolution(TwoSum3.class);
    }
}
