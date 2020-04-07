package main.medium.threesum_15;

import main.utils.MultiInput;
import main.utils.Solution;

import java.util.*;

/**
 * Solution4.
 *
 * Runtime: 19ms, 75%
 * Space: 43.9, 100%
 *
 * Runtime: O(n^2)
 *
 * - Sort the input (n*log(n))
 * - For each number, skipping any duplicate numbers (n)
 *    do a two sum over the remaining values
 *
 * Space: O(1)
 *
 * We don't need to save any values
 */
class ThreeSum4 extends ThreeSum
{
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

                while (loIndex < hiIndex)
                {
                    int lo = nums[loIndex];
                    int hi = nums[hiIndex];

                    if (lo + hi == target)
                    {
                        result.add(Arrays.asList(nums[i], lo, hi));

                        // take care of duplicate values in the remaining numbers
                        // e.g. given input -2,0,0,2,2

                        while ((loIndex < hiIndex) && (nums[loIndex] == nums[loIndex + 1]))
                        {
                            loIndex++;
                        }

                        while ((loIndex < hiIndex) && (nums[hiIndex] == nums[hiIndex - 1]))
                        {
                            hiIndex--;
                        }


                        hiIndex--;
                        loIndex++;
                    }
                    // target is lower, so we need to decrease the bigger number so move 'hi' index to the left
                    else if (lo + hi > target)
                    {
                        hiIndex--;
                    }
                    else
                    {
                        loIndex++;
                    }
                }
            }
        }

        return result;
    }

    /**
     * Like two sum, but we return a tuple of values rather than indices.
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> twoSumValues(int[] nums, int target)
    {
        List<List<Integer>> allResults = new ArrayList<>();

        // since we want to sum to zero, target is inverse of current number
        int inverseTarget = target * -1;

        Set<Integer> valueSet = new HashSet<>(nums.length - 1, 1);

        // store the values into a map with <key,value> == <value,index>
        // skip the first value since obviously we need a pair
        for (int index = 0; index < nums.length; index++)
        {
            int baseValue = nums[index];
            int complement = inverseTarget - baseValue;

            if (valueSet.contains(complement))
            {
                List<Integer> result = new ArrayList<>();


                result.add(target);
                result.add(baseValue);
                result.add(complement);

                allResults.add(result);
            }

            valueSet.add(baseValue);
        }

        return allResults;
    }
}
