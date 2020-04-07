package main.medium.threesum_15;

import main.utils.MultiInput;
import main.utils.Solution;

import java.util.*;

/**
 * SolutionEx1
 *
 * Runtime: 395ms, 13.8%
 * Space: 44mb, 99.65%
 *
 * 3sum is really like 'two sum' except the 'target' is our current value
 */
class ThreeSumEx1 extends ThreeSum
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        // https://leetcode.com/problems/3sum/discuss/508631/Simple-O(n2)-Java-solution-with-explanations
        Set<List<Integer>> threeSumSet = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++)
        {                         //Doing length-2, because we want two elems j and k after i.
            int j = i + 1;

            int k = nums.length - 1;

            while (j < k)
            {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0)
                {
                    threeSumSet.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;
                } else if (sum > 0)
                {
                    k--;
                } else if (sum < 0)
                {
                    j++;
                }
            }

        }

        return new ArrayList<>(threeSumSet);
    }
}
