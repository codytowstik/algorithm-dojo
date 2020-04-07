package main.medium.threesum_15;

import main.utils.MultiInput;
import main.utils.Solution;

import java.util.*;

/**
 * Solution2.
 *
 * Runtime: O(n^2)
 *
 * for each number, (n)
 *   2sum (n)
 *   => n * n => n^2
 *
 * Space: O(n)
 *
 * - we store a hash value for each possible triplet (less than n)
 * - 2sum hash map, recreated n times
 *
 * This approach tries to track which triplets we have already saved by adding resulting sets hash codes
 * to a map. This is bad for 2 reasons.
 * - triplets can have the same hash value (and computing it is expensive anyways) .. so this fails on large
 *   sets of data that have triplets that hash to the same value (collisions)
 * - we are storing a huge amount of data
 */
public class ThreeSum2 extends ThreeSum
{
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
            int baseValue = nums[i];

            // for each other number with greater index,

            int[] subArray = copyArrayMinusIndex(nums, i);

            // if subarray has at least two values (since this is three sum)

            if (subArray.length >= 2)
            {
                List<List<Integer>> results = twoSumValues(subArray, baseValue);

                for (List<Integer> result : results)
                {
                    int first = result.get(0);
                    int second = result.get(1);
                    int third = result.get(2);

                    List<Integer> resultTriplet = createOrderedResults(first, second, third);

                    addResult(resultTriplet, resultTriplets, existingResults);
                }
            }
        }

        return resultTriplets;
    }

    /**
     * Create an ordered 3-sized list out of the given inputs.
     *
     * @param one   first num
     * @param two   second num
     * @param three third num
     * @return an ordered list of the given numbers
     */
    public List<Integer> createOrderedResults(int one, int two, int three)
    {
        List<Integer> result = new ArrayList<>(3);

        int minValue = Math.min(one, Math.min(two, three));
        int maxValue = Math.max(one, Math.max(two, three));

        int middleValue = (one + two + three) - minValue - maxValue;

        result.add(minValue);
        result.add(middleValue);
        result.add(maxValue);

        return result;
    }

    /**
     * Check if the hashcode of the given result is in the existingResultsHash set.
     * If not, add the result to the list of results (and result hashes)
     *
     * @param result              the result to check
     * @param results             the set of results to add to
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

    /**
     * Like two sum, but we return a tuple of values rather than indices.
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> twoSumValues(int[] nums, int target)
    {
        List<List<Integer>>   allResults = new ArrayList<>();

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

    private int[] copyArrayMinusIndex(int[] original, int index)
    {
        int[] copy = new int[original.length - 1];

        int copyIndex = 0;

        for (int i = 0; i < original.length; i++)
        {
            if (i != index)
            {
                copy[copyIndex++] = original[i];
            }
        }

        return copy;
    }
}
