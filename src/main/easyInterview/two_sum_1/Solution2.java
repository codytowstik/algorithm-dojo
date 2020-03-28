package main.easyInterview.two_sum_1;

import main.utils.MultiInput;
import main.utils.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution2.
 *
 * No improvement (as expected).
 *
 * Solution1 as template.
 *
 * - give 'processedValues' HashMap load factor of 1 so it doesn't grow.
 * - don't store the first value, since we won't ever need it
 */
class Solution2 extends Solution
{
    public Object execute(Object input)
    {
        MultiInput multiInput = (MultiInput) input;

        int[] nums = multiInput.getArrayInt(0);
        int target = multiInput.getInt(1);

        return twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer,Integer>     processedValues = new HashMap<>( nums.length-1, 1 );

        // store the values into a map with <key,value> == <value,index>
        for (int index = 1; index < nums.length; index++)
        {
            int     inputNumber = nums[index];

            processedValues.put( inputNumber, index);
        }

        // for each value, see if there is a pair that results in the value

        for (int index = 0; index < nums.length; index++)
        {
            int firstValue = nums[index];

            int requiredValue = target - firstValue;

            Integer pairIndex = processedValues.get(requiredValue);

            // if we didn't find a match or the index is the same as the current number, no dice
            if ((pairIndex != null) && (pairIndex != index))
            {
                return new int[]{index, pairIndex};
            }
        }

        // it should always have a solution
        return new int[]{};
    }
}
