package main.easy.two_sum_1;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution3.
 *
 * 1ms, 99.89%
 * 40.1mb, 5.65%
 *
 * Runtime: O(n)
 * Space: O(n)
 *
 * Like solution 1/2, except we do one pass.
 *
 * Iterate through the array
 * - see if any value in the map gets us our target
 *      - if not, add the current value to the map
 *      - if yes, return
 */
public class TwoSum3 extends TwoSum
{
    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer,Integer>     processedValues = new HashMap<>( nums.length-1, 1 );

        processedValues.put(nums[0], 0);

        // store the values into a map with <key,value> == <value,index>
        // skip the first value since obviously we need a pair
        for (int index = 1; index < nums.length; index++)
        {
            int     baseValue = nums[index];
            int     complement = target - baseValue;

            if (processedValues.containsKey(complement))
            {
                int complementIndex = processedValues.get(complement);

                return new int[]{complementIndex, index};
            }

            processedValues.put( baseValue, index);
        }

        // it should always have a solution
        return new int[]{};
    }
}
