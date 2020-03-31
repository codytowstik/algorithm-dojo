package main.medium.threesum_15;

import main.utils.MultiInput;
import main.utils.Solution;

import java.util.*;

/**
 * SolutionEx0.
 *
 * Runtime: 19ms, 75%
 * Space: 43.5mb, 100%
 *
 * Runtime: O(n^2)
 * Space: O(1)
 *
 * uses bi-directional search for each 2Sum sweep of the remaining array.
 * skip duplicates to avoid duplicates in answer without making a set.
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
        // https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++)
        {
            // we are on first number or previous number equals this number
            // i.e. skip duplicates because any triplets we find with a duplicate value will be duplicates of the previous
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
