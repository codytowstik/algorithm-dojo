package main.easy.two_sum_1;

import main.utils.MultiInput;
import main.utils.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution1.
 *
 * 2ms, 65.1%
 * 40.2mb, 5.65%
 *
 * Runtime: O(n)
 * Space: O(n)
 *
 * Two passes.
 * Pass 1: Load each value into a map, storing the index as the value.
 * Pass 2: See if there is a value in the map that would hit our target sum.
 */
class Solution1 extends Solution
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
        Map<Integer,Integer>     processedValues = new HashMap<>( nums.length );

        // store the values into a map with <key,value> == <value,index>
        for (int index = 0; index < nums.length; index++)
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
