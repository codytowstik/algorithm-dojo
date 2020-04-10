package main.threesum_15;

import java.util.*;

/**
 * Solution1 - Brute Force, no ordered output
 *
 * Same as solution0, except we don't care about result sort.
 *
 * RESULT: Order doesn't matter for individual tuples
 *
 * [[-1,0,1],[-1,2,-1]] == [[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum1 extends ThreeSum
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
                        List<Integer>   resultTriplet = createResult(firstValue, secondValue, thirdValue);

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
}
