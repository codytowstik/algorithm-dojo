package main.medium.threesum_15;

import main.utils.MultiInput;
import main.utils.Solution;

import java.util.*;

/**
 * Solution3.
 *
 * Runtime: O(n^2)
 *
 * - Sort the input (n*log(n))
 * - For each number, skipping any duplicate numbers (n)
 *    do a bidirectional search of remaining numbers to see if a pair adds up to the complement of the base number (n)
 *
 * Space: O(1)
 *
 * We don't need to save any values
 */
class Solution3 extends Solution
{
    public Object execute(Object input)
    {
        MultiInput  multiInput = (MultiInput) input;

        int[]       nums = multiInput.parseArrayInt(0);

        return threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new LinkedList<>();

        Arrays.sort(nums);

        // we can safely skip the last two numbers because there won't be enough for a triplet
        for (int i = 0; i < nums.length - 2; i++)
        {
            // skip duplicates .. i.e consecutive same values in our now-sorted input
            // this is what saves us from
            if ((i == 0) || (nums[i] != nums[i - 1]))
            {
                // target is negative number we are at (a + b + c = 0 ==> b + c = -a)
                int target = 0 - nums[i];

                int loIndex = i + 1;
                int hiIndex = nums.length - 1;

                int lo = nums[loIndex];
                int hi = nums[hiIndex];

                while (lo < hi)
                {
                    if (lo + hi == target)
                    {
                        result.add(Arrays.asList(nums[i], lo, hi));

                        hi = nums[--hiIndex];
                        lo = nums[++loIndex];
                    }
                    // target is lower, so we need to decrease the bigger number so move 'hi' index to the left
                    else if (lo + hi > target)
                    {
                        hi = nums[--hiIndex];
                    }
                    else
                    {
                        lo = nums[++loIndex];
                    }
                }
            }
        }

        return result;
    }
}
