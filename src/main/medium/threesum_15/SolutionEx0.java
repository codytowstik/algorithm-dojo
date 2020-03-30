package main.medium.threesum_15;

import main.utils.MultiInput;
import main.utils.Solution;

import java.util.*;

/**
 * SolutionEx0.
 *
 * Runtime: 20ms, 58%
 * Space: 44mb
 *
 * 3sum is really like 'two sum' except the 'target' is our current value
 */
class SolutionEx0 extends Solution
{
    public Object execute(Object input) {
        MultiInput      multiInput = (MultiInput) input;

        int[]           nums = multiInput.parseArrayInt(0);

        return threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++)
        {
            // we are on first number or previous number equals this number
            if (i == 0 || (nums[i] != nums[i - 1]) )
            {
                int lo = i + 1;
                int hi = nums.length - 1;
                int targetSum = 0 - nums[i];

                while (lo < hi)
                {
                    int sum = nums[lo] + nums[hi];

                    if ( sum == targetSum)
                    {
                        List<Integer> resultTriplet = Arrays.asList(nums[i], nums[lo], nums[hi]);

                        res.add(resultTriplet);

                        while (lo < hi && nums[lo] == nums[lo + 1])
                        {
                            lo++;
                        }

                        while (lo < hi && nums[hi] == nums[hi - 1])
                        {
                            hi--;
                        }

                        lo++;
                        hi--;
                    }
                    else if (sum < targetSum)
                    {
                        lo++;
                    }
                    else
                    {
                        hi--;
                    }
                }
            }
        }

        return res;
    }
}
