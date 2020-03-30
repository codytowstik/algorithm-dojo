package main.medium.threesum_15;

import main.utils.MultiInput;
import main.utils.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
class Solution1 extends Solution
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
                        List<Integer>   resultTriplet = createOrderedResults(firstValue, secondValue, thirdValue);

                        // append the result triplet
                        addResult(resultTriplet, resultTriplets, existingResults );
                    }
                }
            }
        }

        return resultTriplets;
    }

    /**
     * Create an ordered 3-sized list out of the given inputs.
     *
     * @param one
     * @param two
     * @param three
     * @return
     */
    public List<Integer> createOrderedResults(int one, int two, int three)
    {
        List<Integer> result = new ArrayList<>(3);

        int minValue = Math.min(one, Math.min(two, three));
        int maxValue = Math.max(one, Math.max(two, three));

        int middleValue = (one+two+three) - minValue - maxValue;

        result.add(minValue);
        result.add(middleValue);
        result.add(maxValue);

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
        int currentResultHash = result.hashCode();

        if (!existingResultsHash.contains(currentResultHash))
        {
            results.add(result);
            existingResultsHash.add(currentResultHash);
        }
    }
}
