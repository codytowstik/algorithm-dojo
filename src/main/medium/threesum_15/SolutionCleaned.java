package main.medium.threesum_15;

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
class SolutionCleaned extends Solution
{
    public Object execute(Object input)
    {
        MultiInput multiInput = (MultiInput) input;

        int[] nums = multiInput.parseArrayInt(0);
        int target = multiInput.parseInt(1);

        return twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer,Integer>     processedValues = new HashMap<>( nums.length-2, 1 );

        processedValues.put(nums[0], 0);

        for (int index = 1; index < nums.length; index++)
        {
            int     requiredValue = target - nums[index];

            if (processedValues.containsKey(requiredValue))
            {
                return new int[]{processedValues.get(requiredValue), index};
            }

            processedValues.put(nums[index], index);
        }

        return new int[]{};
    }
}
