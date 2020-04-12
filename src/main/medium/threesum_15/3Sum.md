# 3Sum - 15

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = `[-1, 0, 1, 2, -1, -4],`

A solution set is:

    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]

## Approach 1 - Brute Force

Runtime: O(n^2)

For each element (n) we iterate over all (n) numbers to see if any give us our target. => n * n

Space: O(1)

We don't store anything.

## Approach 2 - Two Pass

Runtime: O(n)

For each element (n), we store the value and index in a hash table(1).
For each element (n), we check if there is a pair in the map that would give us our target (1).
=> n + n => 2n => O(n)

Space: O(n)

We store each value in the hash table.

## Approach 3 - One Pass

For each element (n), we check if a hash table has our required value(1), return if we do, else add the value to our table (1).
=> n * (1 + 1) => 2n => O(n)





