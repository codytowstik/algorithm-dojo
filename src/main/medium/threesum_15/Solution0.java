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
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> subList1 = new ArrayList<>();

        subList1.add(-1);
        subList1.add(0);
        subList1.add(1);

        List<Integer> subList2 = new ArrayList<>();

        subList2.add(-1);
        subList2.add(-1);
        subList2.add(2);

        result.add(subList1);
        result.add(subList2);

        return result;
    }
}
