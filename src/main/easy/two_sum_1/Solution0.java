package main.easy.two_sum_1;

import main.utils.MultiInput;
import main.utils.Solution;

/**
 * Solution0.
 *
 * Naive solution.
 *
 * Runtime: O(n^2)
 * Space: O(1)
 *
 * For each number, see if any other number sums up to the target. If so, save indices and return them.
 */
class Solution0 extends Solution
{
    public Object execute(Object input) {
        MultiInput      multiInput = (MultiInput) input;

        int[]           nums = multiInput.getArrayInt(0);
        int             target = multiInput.getInt(1);

        return twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target)
    {
        // for each number
        for (int i = 0; i < nums.length; i++)
        {
            int     firstNumber = nums[i];

            // see if there is a pair that results in target value
            for (int j = 0; j < nums.length; j++)
            {
                int     secondNumber = nums[j];

                if ( firstNumber + secondNumber == target)
                {
                    return new int[]{i,j};
                }
            }
        }

        // it should always have a solution
        return new int[]{};
    }
}
