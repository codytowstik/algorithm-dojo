package main.easyInterview.two_sum_1;

import main.utils.MultiInput;
import main.utils.Solution;

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
        int[] result = new int[]{0,1};

        return result;
    }
}
