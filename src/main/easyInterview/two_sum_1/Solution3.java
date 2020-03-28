package main.easyInterview.two_sum_1;

import main.utils.MultiInput;
import main.utils.Solution;

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
class Solution3 extends Solution
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

        processedValues.put(nums[0], 0);

        // store the values into a map with <key,value> == <value,index>
        // skip the first value since obviously we need a pair
        for (int index = 1; index < nums.length; index++)
        {
            int     secondValue = nums[index];
            int     requiredValue = target - secondValue;

            if (processedValues.containsKey(requiredValue))
            {
                int firstValueIndex = processedValues.get(requiredValue);

                return new int[]{firstValueIndex, index};
            }

            processedValues.put( secondValue, index);
        }

        // it should always have a solution
        return new int[]{};
    }
}
