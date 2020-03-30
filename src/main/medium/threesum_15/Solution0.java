package main.medium.threesum_15;

import main.utils.MultiInput;
import main.utils.Solution;

import java.util.ArrayList;
import java.util.List;

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

        int[]           nums = multiInput.parseArrayInt(0);

        return threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums)
    {
        // for each number,
        //   for each other number with greater index,
        //     see if there is a value (with greater index) that sums us to zero

        List<List<Integer>> resultTriplets = new ArrayList<>();

        // for each number

        for (int i = 0; i < nums.length; i++)
        {
            int firstValue = nums[i];

            // for each other number with greater index,

            for (int j = (i + 1); j < nums.length; j++)
            {

                int secondValue = nums[j];
                int twoValueSum = firstValue + secondValue;

                // see if there is a value (with greater index) that sums us to zero

                for (int k = (j + 1); k < nums.length; k++)
                {
                    int thirdValue = nums[k];
                    int threeValueSum = twoValueSum + thirdValue;

                    if (threeValueSum == 0)
                    {
                        List<Integer> resultTriplet = new ArrayList<>();

                        resultTriplet.add(firstValue);
                        resultTriplet.add(secondValue);
                        resultTriplet.add(thirdValue);

                        // append the result triplet
                        resultTriplets.add(resultTriplet);
                    }
                }
            }
        }

        return resultTriplets;
    }
}
