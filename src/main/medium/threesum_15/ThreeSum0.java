package main.medium.threesum_15;

import java.util.*;

/**
 * Solution0 - Brute Force, ordered output
 *
 * Time Limit Exceeded
 *
 * Runtime: O(n^3)
 * for each number,
 *   for each other number with greater index,
 *    see if there is a value (with greater index) that sums us to zero
 *
 * Space: 0(n)
 *
 * We store the hash of each triplet (ordered) to check for duplicate results
 */
public class ThreeSum0 extends ThreeSum
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
     * @param one first num
     * @param two second num
     * @param three third num
     * @return an ordered list of the given numbers
     */
    private List<Integer> createOrderedResults(int one, int two, int three)
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
    private void addResult(List<Integer> result, List<List<Integer>> results, Set<Integer> existingResultsHash)
    {
        int currentResultHash = result.hashCode();

        if (!existingResultsHash.contains(currentResultHash))
        {
            results.add(result);
            existingResultsHash.add(currentResultHash);
        }
    }
}
