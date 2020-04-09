package main.scratch;

import main.easy.two_sum_1.TwoSumCleaned;

/**
 * Optimized algorithms from existing solutions.
 *
 * Some problems are a superset of previous solutions, so here are our optimized solutions for use in other
 * problems.
 *
 * For example,
 * Two Sum
 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *      input: 0,1,2/3
 *      return int[2] => [1,2]
 * Two Sum on Steroids
 *  Given an array of integers, return indices of the two numbers such that they add up to an array of targets.
 *      input: 0,1,2/3,1
 *      return List<List<Integer>> => [[1,2],[0,1]]
 *
 */
public final class PreviousSolutionUtils
{
    public static int[] twoSum(int[] nums, int target)
    {
        TwoSumCleaned twoSumCleaned = new TwoSumCleaned();

        return twoSumCleaned.twoSum(nums, target);
    }
}
