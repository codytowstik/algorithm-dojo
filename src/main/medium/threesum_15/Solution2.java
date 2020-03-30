package main.medium.threesum_15;

import main.utils.MultiInput;
import main.utils.Solution;

import java.util.*;

/**
 * Solution2.
 *
 * Runtime:
 * Space:
 *
 * 3sum is really like 'two sum' except the 'target' is our current value
 */
class Solution2 extends Solution
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

        Set<Integer> existingResults = new HashSet<>();

        // for each number

        for (int i = 0; i < nums.length; i++)
        {
            // since we want to sum to zero, target is inverse of current number
            int target = nums[i] * -1;

            // for each other number with greater index,

            int indexToCheck = i + 1;

            int[] subArray = Arrays.copyOfRange(nums, 0, i);

            // if subarray has at least two values (since this is three sum)

            if (subArray.length >= 2)
            {
                int[] tupleResult = twoSumValues(subArray, target);

                // if we found results, add them!
                if (tupleResult.length != 0)
                {
                    int first = nums[i];
                    int second = tupleResult[0];
                    int third = tupleResult[1];

                    List<Integer> resultTriplet = createResult(first, second, third);

                    addResult(resultTriplet, resultTriplets, existingResults);
                }
            }
        }

        return resultTriplets;
    }

    /**
     * Create an ordered 3-sized list out of the given inputs.
     *
     * @param one first num
     * @param two second num
     * @param three third num
     * @return a list of the given inputs
     */
    public List<Integer> createResult(int one, int two, int three)
    {
        List<Integer> result = new ArrayList<>(3);

        result.add(one);
        result.add(two);
        result.add(three);

        return result;
    }

    /**
     * Check if the hashcode of the given result is in the existingResultsHash set.
     * If not, add the result to the list of results (and result hashes)
     *
     * @param result the result to check
     * @param results the set of results to add to
     * @param existingResultsHash a set of hashes for existing result sets.
     */
    public void addResult(List<Integer> result, List<List<Integer>> results, Set<Integer> existingResultsHash)
    {
        // copy the list so it doesn't affect our output, we are just checking if order matters
        List<Integer> resultOrdered = new ArrayList<>(result);

        Collections.sort(resultOrdered);

        int currentResultHash = resultOrdered.hashCode();

        if (!existingResultsHash.contains(currentResultHash))
        {
            results.add(result);
            existingResultsHash.add(currentResultHash);
        }
    }

    /**
     * Like two sum, but we return a tuple of values rather than indices.
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumValues(int[] nums, int target)
    {
        Set<Integer> valueSet = new HashSet<>(nums.length - 1, 1);

        // store the values into a map with <key,value> == <value,index>
        // skip the first value since obviously we need a pair
        for (int index = 0; index < nums.length; index++)
        {
            int baseValue = nums[index];
            int complement = target - baseValue;

            if (valueSet.contains(complement))
            {
                return new int[]{baseValue, complement};
            }

            valueSet.add(baseValue);
        }

        return new int[]{};
    }
}
